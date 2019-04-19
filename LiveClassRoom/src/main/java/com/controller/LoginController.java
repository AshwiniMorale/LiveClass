package com.controller;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserDetails;
import com.daoImpl.SaveImpl;
import com.services.SendEmail;
import com.services.SendMessage;


@Controller
public class LoginController
{
	//@Autowired(required=true)
	SaveImpl saveimpl = new SaveImpl();
	Properties prop=new Properties(); 
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("UserDetails") UserDetails userdetailob, HttpServletRequest req, HttpServletResponse res)
	{
		System.out.println("Registration:: register controoler called.");
		System.out.println(userdetailob.getEmailId() +" "+ userdetailob.getMobileNo());
		if(saveimpl.checkUser(userdetailob.getEmailId() , userdetailob.getMobileNo()))
		{
			System.out.println("LoginController::checkUser returned with true.");
			return new ModelAndView("register","message","sorry email id  is alredy presesnt ");
		}
		else
		{
			System.out.println("LoginController::checkUser returned with false.");
			try{
				FileReader reader=new FileReader("ClassPath:config.properties");
				prop.load(reader);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			saveimpl.register(userdetailob);
			System.out.println("return after register in db");
			String from=prop.getProperty("fromEmail");
			System.out.println(prop.getProperty("fromEmail"));
			String password=prop.getProperty("password");
			String to=userdetailob.getEmailId();
			String sub=prop.getProperty("subject");
			String mobileNo=userdetailob.getMobileNo();
			String msg=prop.getProperty("message"); 
			SendEmail.send(from, password, to, sub, msg);
			SendMessage.sendMsg(mobileNo, msg);
			return new ModelAndView("login","message","sucessfully register");
		}
		
		
	}
	
	@RequestMapping(value = "/login", method =  RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res)
	{
		
		System.out.println("longin controoler called");
		boolean status = false;
		String emailId = req.getParameter("emailId");
		String password = req.getParameter("password");
		
		SaveImpl saveimpl = new SaveImpl();
		List listob = saveimpl.login(emailId, password);
		Iterator itr = listob.iterator();
   	 	System.out.println(itr);

         if(itr.hasNext()) 
         {
        	 System.out.println(itr);
        	 status=true; 
         }
		if(status)
		return new ModelAndView("login","message","sucessfully login");
		else
			return new ModelAndView("login","message","login denied");

	}
 
}
