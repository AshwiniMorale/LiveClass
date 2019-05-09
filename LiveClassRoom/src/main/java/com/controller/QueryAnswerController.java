package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserPersonalDetails;
import com.daoImpl.QueryAnswerImpl;

public class QueryAnswerController {
 
	QueryAnswerImpl queryAnswerImpl=new QueryAnswerImpl();
	
	@RequestMapping(value = "/UserPersonalDetails", method = RequestMethod.POST)
	public ModelAndView saveQueryAnswer(@ModelAttribute("UserPersonalDetails") UserPersonalDetails userPersonalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		queryAnswerImpl.saveQueryAnswer();
		System.out.println("saveQueryAnswer:: QueryAnswerController called.");
		return new ModelAndView("UserEducationalDetails", "message", "Wa");
		
	}
	
}
