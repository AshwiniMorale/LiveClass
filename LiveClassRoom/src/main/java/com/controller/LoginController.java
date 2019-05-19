package com.controller;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.LogDetails;
import com.bean.UserDetails;
import com.dao.LogDao;
import com.dao.SaveDao;
import com.services.SendEmail;
import com.services.SendMessage;

@Controller
public class LoginController {

	@Autowired
	SaveDao saveimpl;

	@Autowired
	LogDao logDaoImpl;

	static String MSGSUCCESS;
	static String MSGDENIED;
	static String MSGLOGOUT;
	static String REGSUBJECT;
	static String MSGEMAIL;
	static String FORGETPASSSUB;
	static String MSGFORGETPASS;
	static String FROMMAIL;
	static String FROMPASS;
	static final String MESSAGE = "message";
	static final String LOGIN = "login";
	
	ResourceBundle rb;
	LogDetails logDetails;

	LoginController() {
		System.out.println("Constroctur():-->LoginController.class");
		rb = ResourceBundle.getBundle("application");
		MSGSUCCESS = rb.getString("msgSuccess");
		MSGDENIED = rb.getString("msgDenied");
		MSGLOGOUT = rb.getString("msgLogout");
		REGSUBJECT = rb.getString("regSubject");
		MSGEMAIL = rb.getString("msgEmail");
		FORGETPASSSUB = rb.getString("forgetPassSub");
		MSGFORGETPASS = rb.getString("msgForgetPass");
		FROMMAIL = rb.getString("fromEmail");
		FROMPASS = rb.getString("password");
	}

	@PostMapping("/register")
	public ModelAndView registration(@ModelAttribute("UserDetails") UserDetails userDetail, HttpServletRequest req,
			HttpServletResponse res) {

		System.out.println("Registration:: register() Controller called.");
		// Reading Data From Object File...
		String to = userDetail.getEmailId();
		String mobileNo = userDetail.getMobileNo();
		
		if (saveimpl.checkUser(userDetail.getEmailId(), userDetail.getMobileNo())) {
			System.out.println("LoginController::checkUser() returned with true.");
			return new ModelAndView("register", MESSAGE, "Sorry email id  is alredy presesnt ");

		} else {
			System.out.println("LoginController::checkUser() returned with false.");
			int userId=saveimpl.register(userDetail);
			HttpSession session = req.getSession();
			session.setAttribute("userId", userId);
			MSGEMAIL = "Hello " + userDetail.getFirstName() + "," + "\n\n\n" + MSGEMAIL;
			System.out.println(
					FROMMAIL + "\n" + FROMPASS + "\n" + to + "\n" + REGSUBJECT + "\n" + mobileNo + "\n" + MSGEMAIL);
			// Send Message to User:
			SendEmail.send(FROMMAIL, FROMPASS, to, REGSUBJECT, MSGEMAIL);
			SendMessage.sendMsg(mobileNo, MSGEMAIL);
			return new ModelAndView("usr-personal", MESSAGE, MSGSUCCESS);
		}
	}

	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Registration:: login() Controller called.");
		String emailId = req.getParameter("emailId");
		String password = req.getParameter("password");

		List<UserDetails> list = saveimpl.login(emailId, password);

		int logId=0;
		int userId = 0;
		int roleId = 0;
		String userName = null;
		boolean status = false;
		String dbEmail = null;

		for (UserDetails ob : list) {
			userId = ob.getUserId();
			roleId = ob.getRoleId();
			userName = ob.getFirstName() + " " + ob.getLastName();
			dbEmail = ob.getEmailId();
			status = true;
		}

		if (status) {
			logDetails = new LogDetails();
			logDetails.setUserId(userId);
			logDetails.setLoginTime(new Date());
			System.out.println(new Date());
			HttpSession httpSession = req.getSession();

			if (!httpSession.isNew()) {
				httpSession.invalidate();
				httpSession = req.getSession();
				httpSession.setMaxInactiveInterval(0);
			}
			logId = logDaoImpl.saveLogDetails(logDetails);
			httpSession.setAttribute("userId", userId);
			httpSession.setAttribute("roleId", roleId);
			httpSession.setAttribute("userName", userName);
			httpSession.setAttribute("emailId", dbEmail);
			httpSession.setAttribute("logId", logId);
			
			if (roleId == 1)
				return new ModelAndView("adminDashboard");
			else if (roleId == 2)
				return new ModelAndView("facultyDashboard");
			else
				return new ModelAndView("stuDashboard");
		} else
			return new ModelAndView(LOGIN, MESSAGE, MSGDENIED);

	}

	@PostMapping("/logout")
	public ModelAndView logOut(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Registration:: logOut() Controller called.");
		HttpSession httpSession = req.getSession();
		int logId = 0;

		logId = (int) httpSession.getAttribute("logId");
		logDaoImpl.updateLog(logId);
		if (!httpSession.isNew()) {
			httpSession.invalidate();
			httpSession = req.getSession();
			httpSession.setMaxInactiveInterval(0);
		}
		httpSession.removeAttribute("logId");
		httpSession.removeAttribute("userId");
		httpSession.removeAttribute("roleId");
		httpSession.removeAttribute("userName");
		httpSession.removeAttribute("emailId");
		return new ModelAndView(LOGIN, MESSAGE, MSGLOGOUT);
	}

	@PostMapping("/forget")
	public ModelAndView forgetPass(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Registration:: forgetPass() Controller called.");
		String emailId = req.getParameter("emailId");
		List<UserDetails> list = null;
		String password = null;
		list = saveimpl.forgetPassword(emailId);
		for (UserDetails ob : list) {
			password = ob.getPassword();
		}
		if (password.equals(null))
			return new ModelAndView("forgetpass", MESSAGE, "Please Enter Valid Email Id...");
		else {
			String from = rb.getString("fromEmail");
			String mailpassword = rb.getString("password");
			String sub = rb.getString("forgetPassSub");
			String msgpass = "Your Password is:--> " + password;

			SendEmail.send(from, mailpassword, emailId, sub, msgpass);
			return new ModelAndView("forgetpass", MESSAGE, "A mail has been Sent to Your registerd Email Id...");
		}

	}
}
