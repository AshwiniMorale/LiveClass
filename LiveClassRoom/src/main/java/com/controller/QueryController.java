package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Query1;
import com.daoImpl.QueryImpl;

@Controller
public class QueryController {

	int userId = 0;
	static final String MESSAGE = "message";

	@Autowired
	QueryImpl queryImpl;
	
	@RequestMapping(value = "/savequery1", method = RequestMethod.POST)
	public ModelAndView saveQuery(@ModelAttribute("Query1") Query1 query, HttpServletRequest req, HttpServletResponse res)
	{
		System.out.println(":: saveQuery() called:-->QueryController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		System.out.println("userId from sessiom:-->" + userId);
		query.setUserId(userId);
		queryImpl.saveQuery1(query);
		System.out.println("saveQuery:: QueryController called.");
		return new ModelAndView("stuDashboard", MESSAGE, "your query have been saved successfully");
		
	}
}
