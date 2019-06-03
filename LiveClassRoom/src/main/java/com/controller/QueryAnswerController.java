package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.QueryAnswer;
import com.daoImpl.QueryAnswerImpl;

public class QueryAnswerController {
 
	int userId = 0;
	static final String MESSAGE = "message";
	@Autowired
	QueryAnswerImpl queryAnswerImpl;
	
	@RequestMapping(value = "/saveanswer", method = RequestMethod.POST)
	public ModelAndView saveQueryAnswer(@ModelAttribute("QueryAnswer") QueryAnswer queryAnswer, HttpServletRequest req, HttpServletResponse res)
	{
		System.out.println(":: saveQueryAnswer() called:-->QueryAnswerController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		System.out.println("userId from sessiom:-->" + userId);
		queryAnswer.setUserId(userId);
		queryAnswerImpl.saveQueryAnswer(queryAnswer);
		System.out.println("saveQueryAnswer:: QueryAnswerController called.");
		return new ModelAndView("facultyDashboard", MESSAGE, "answere submit successfully");
		
	}
	
}
