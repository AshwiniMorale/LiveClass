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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.LogDetails;
import com.bean.UserDetails;
import com.dao.LogDao;
import com.dao.SaveDao;
import com.services.SendEmail;
import com.services.SendMessage;

@Controller
public class LoginController {

	LoginController() {
		System.out.println("Constroctur:");
	}

	@Autowired
	SaveDao saveimpl;

	@Autowired
	LogDao logDaoImpl;

	LogDetails logDetails;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("UserDetails") UserDetails userDetail, HttpServletRequest req,
			HttpServletResponse res) {

		System.out.println("Registration:: register() Controller called.");
		System.out.println(userDetail.getEmailId() + " " + userDetail.getMobileNo());

		if (saveimpl.checkUser(userDetail.getEmailId(), userDetail.getMobileNo())) {
			System.out.println("LoginController::checkUser() returned with true.");
			return new ModelAndView("register", "message", "sorry email id  is alredy presesnt ");

		} else {
			System.out.println("LoginController::checkUser() returned with false.");
			ResourceBundle rb = ResourceBundle.getBundle("application");
			saveimpl.register(userDetail);

			// Reading Data From Properties File...
			String from = rb.getString("fromEmail");
			String password = rb.getString("password");
			String to = userDetail.getEmailId();
			String sub = rb.getString("subject");
			String mobileNo = userDetail.getMobileNo();
			String msg = rb.getString("hello") + " " + userDetail.getFirstName() + "," + "\n" + rb.getString("msg");
			System.out.println(from + "\n" + password + "\n" + to + "\n" + sub + "\n" + mobileNo);
			System.out.println("msg From Properties File: " + msg);
			// Send Message to User:
			SendEmail.send(from, password, to, sub, msg);
			SendMessage.sendMsg(mobileNo, msg);
			return new ModelAndView("login", "message", "Congrats you have suceessfully registered.");
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Registration:: login() Controller called.");

		String emailId = req.getParameter("emailId");
		String password = req.getParameter("password");

		List<UserDetails> list = saveimpl.login(emailId, password);

		int userId = 0;
		int roleId = 0;
		String userName = null;
		boolean status = false;
		String dbEmail = null;

		for (UserDetails ob : list) {
			userId = ob.getUserId();
			roleId = ob.getRole();
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

			httpSession.setAttribute("userId", userId);
			httpSession.setAttribute("roleId", roleId);
			httpSession.setAttribute("userName", userName);
			httpSession.setAttribute("emailId", dbEmail);
			boolean usrStatus = logDaoImpl.returnLogDetails(userId);
			logDaoImpl.saveLogDetails(logDetails);
			if (roleId == 1)
				return new ModelAndView("adminDashBoard");
			else if (roleId == 2)
				return new ModelAndView("FacDeshBoard");
			else if (usrStatus)
				return new ModelAndView("stuDashboard");
			else
				return new ModelAndView("UserPersonalDetails");
		} else
			return new ModelAndView("login", "message", "login denied");

	}

	@RequestMapping(value = "/loginout", method = RequestMethod.POST)
	public ModelAndView loginOut(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Registration:: loginOut() Controller called.");

		return new ModelAndView("login", "message", "login out Successfully...");
	}

	@RequestMapping(value = "/forget", method = RequestMethod.POST)
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
			return new ModelAndView("forgetpass", "message", "Please Enter Valid Email Id...");
		else {
			ResourceBundle rb = ResourceBundle.getBundle("config");
			String from = rb.getString("fromEmail");
			String mailpassword = rb.getString("password");
			String sub = rb.getString("pfSubject");
			String msg = "Your Password is:--> " + password;

			SendEmail.send(from, mailpassword, emailId, sub, msg);
			return new ModelAndView("forgetpass", "message", "A mail has been Sent to Your registerd Email Id...");
		}

	}
}
