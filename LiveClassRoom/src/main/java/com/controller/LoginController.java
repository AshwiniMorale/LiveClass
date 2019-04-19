package com.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserDetails;
import com.daoImpl.SaveImpl;

@Controller
public class LoginController
{
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("UserDetails") UserDetails userdetailob, HttpServletRequest req, HttpServletResponse res)
	{
		System.out.println("longin controoler called");
		SaveImpl saveimpl = new SaveImpl();
		saveimpl.register(userdetailob);
		return new ModelAndView("register","message","sucessfully register");
		
	}
	
	@RequestMapping(value = "/login", method =  RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("UserDetails") UserDetails userdetailob, HttpServletRequest req, HttpServletResponse res)
	{
		
		System.out.println("longin controoler called");
		boolean status = false;
		String email = req.getParameter("email");
		String pass = req.getParameter("name");
		
		SaveImpl saveimpl = new SaveImpl();
		List listob = saveimpl.login(email, pass);
		Iterator itr = listob.iterator();
   	 	System.out.println(itr);

         while(itr.hasNext()) 
         {
        	 System.out.println(itr);
        	 status=true; 
         }
		if(status)
		return new ModelAndView("index","message","sucessfully login");
		else
			return new ModelAndView("index","message","login denied");

	}
 
}
