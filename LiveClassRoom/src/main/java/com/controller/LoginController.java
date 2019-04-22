package com.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.LogDetails;
import com.bean.UserDetails;
import com.daoImpl.SaveImpl;
import com.services.SendEmail;
import com.services.SendMessage;

@Controller
public class LoginController {
	// @Autowired(required=true)
	SaveImpl saveimpl = new SaveImpl();
	Properties prop = new Properties();
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("UserDetails") UserDetails userDetail, HttpServletRequest req,
			HttpServletResponse res) {
		
		System.out.println("Registration:: register() controller called.");
		System.out.println(userDetail.getEmailId() + " " + userDetail.getMobileNo());

		if (saveimpl.checkUser(userDetail.getEmailId(), userDetail.getMobileNo())) {
			System.out.println("LoginController::checkUser() returned with true.");
			return new ModelAndView("register", "message", "sorry email id  is alredy presesnt ");

		} else {
			System.out.println("LoginController::checkUser() returned with false.");
			ResourceBundle rb = ResourceBundle.getBundle("config");

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

		System.out.println("Registration:: login() controller called.\"");

		String emailId = req.getParameter("emailId");
		String password = req.getParameter("password");

		SaveImpl saveimpl = new SaveImpl();
		List<UserDetails> list = saveimpl.login(emailId, password);

		int userId = 0;
		int roleId = 0;
		String userName = null;
		boolean status = false;
		
		for (UserDetails ob : list) {
			userId = ob.getUserId();
			roleId = ob.getRole();
			userName = ob.getFirstName() + " " + ob.getLastName();
			status = true;
		}

//		Iterator<UserDetails> itr = list.iterator();
//		System.out.println(itr);
		if (status) {
//			System.out.println(itr);

			LogDetails logDetails = new LogDetails();
			logDetails.setUserId(userId);
			logDetails.setLoginTime(new Date());
			System.out.println(new Date());
			HttpSession httpSession = req.getSession();
			System.out.println("old session : " + httpSession.getId());
			System.out.println("session last access time : " + httpSession.getLastAccessedTime());
			System.out.println("max inactive time interval : " + httpSession.getMaxInactiveInterval());
			if (!httpSession.isNew()) {
				httpSession.invalidate();
				httpSession = req.getSession();
				httpSession.setMaxInactiveInterval(0);
				System.out.println("new session:" + httpSession.getId());
			}
			httpSession.setAttribute("userId", userId);
			httpSession.setAttribute("roleId", roleId);
			httpSession.setAttribute("userName", userName);
			saveimpl.logDetails(logDetails);
			
			return new ModelAndView("UserPersonalDetails");
		} else {
			return new ModelAndView("login", "message", "login denied");
		}
	}
}
