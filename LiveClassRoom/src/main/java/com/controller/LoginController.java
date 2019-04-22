package com.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
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
	public ModelAndView registration(@ModelAttribute("UserDetails") UserDetails userdetailob, HttpServletRequest req,
			HttpServletResponse res) {
		System.out.println("Registration:: register controoler called.");
		System.out.println(userdetailob.getEmailId() + " " + userdetailob.getMobileNo());

		if (saveimpl.checkUser(userdetailob.getEmailId(), userdetailob.getMobileNo())) {
			System.out.println("LoginController::checkUser returned with true.");
			return new ModelAndView("register", "message", "sorry email id  is alredy presesnt ");

		} else {
			System.out.println("LoginController::checkUser returned with false.");
			ResourceBundle rb = ResourceBundle.getBundle("config");

			saveimpl.register(userdetailob);
			System.out.println("return after register in db");

			// readnig Data From Properties File...
			String from = rb.getString("fromEmail");
			System.out.println("mailid From Properties File: " + from);

			String password = rb.getString("password");
			System.out.println("password From Properties File: " + password);

			String to = userdetailob.getEmailId();
			System.out.println("to From object : " + to);

			String sub = rb.getString("subject");
			System.out.println("subject From Properties File: " + sub);

			String mobileNo = userdetailob.getMobileNo();
			System.out.println("mobile From object : " + mobileNo);

			String msg = rb.getString("hello") + " " + userdetailob.getFirstName() + "," + "\n" + rb.getString("msg");
			System.out.println("msg From Properties File: " + msg);

			SendEmail.send(from, password, to, sub, msg);
			SendMessage.sendMsg(mobileNo, msg);
			return new ModelAndView("login", "message", "Congrats you have suceessfully registered.");
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {

		System.out.println("longin controoler called");
		boolean status = false;
		
		String emailId = req.getParameter("emailId");
		String password = req.getParameter("password");

		SaveImpl saveimpl = new SaveImpl();
		List<UserDetails> listob = saveimpl.login(emailId, password);
		Iterator itr = listob.iterator();
		System.out.println(itr);
		int userId= 0;
		for(UserDetails ob:listob)
		{
			userId = ob.getUserId();
			
		}

		if (itr.hasNext()) {
			System.out.println(itr);
//			status = true;
			LogDetails logDetails = new LogDetails();
			logDetails.setUserId(userId);
			logDetails.setLoginTime(new Date());
			System.out.println(new Date());
			
			HttpSession httpSession = req.getSession();
			
			System.out.println("old session : " + httpSession.getId());
			System.out.println("session last access time : " + httpSession.getLastAccessedTime());
			System.out.println("max inactive time interval : " + httpSession.getMaxInactiveInterval());
			if (!httpSession.isNew())
			{
				httpSession.invalidate();
				httpSession = req.getSession();
				httpSession.setMaxInactiveInterval(0);
				System.out.println("new session:" + httpSession.getId());
			}
			saveimpl.logDetails(logDetails);
			System.out.println("login controller return and save logv details");
			return new ModelAndView("UserPersonalDetails");
		}
		else
		{
			return new ModelAndView("login", "message", "login denied");
		}
	}
}
