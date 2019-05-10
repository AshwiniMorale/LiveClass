package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserPersonalDetails;
import com.daoImpl.QueryImpl;

@Controller
public class QueryController {

QueryImpl queryImpl=new QueryImpl();
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView saveQuery(@ModelAttribute("UserPersonalDetails") UserPersonalDetails userPersonalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		queryImpl.saveQuery();
		System.out.println("saveQuery:: QueryController called.");
		return new ModelAndView("UserEducationalDetails", "message", "Wa");
		
	}
}
