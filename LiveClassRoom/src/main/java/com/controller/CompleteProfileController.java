package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserEducationalDetails;
import com.bean.UserPersonalDetails;
import com.bean.UserProfessionalDetails;
import com.daoImpl.CompleteProfileImpl;

@Controller
public class CompleteProfileController {

	CompleteProfileImpl completeProfileImpl=new CompleteProfileImpl();

	@RequestMapping(value = "/UserPersonalDetails", method = RequestMethod.POST)
	public ModelAndView saveUserPersonalDetails(@ModelAttribute("UserPersonalDetails") UserPersonalDetails userPersonalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		completeProfileImpl.savePersonalDetails(userPersonalDetails);
		System.out.println("saveUserPersonalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserEducationalDetails", "message", "Your Personal Details have been saved successfully");
		
	}
	
	@RequestMapping(value = "/UserEducationalDetails", method = RequestMethod.POST)
	public ModelAndView saveUserEducationalDetails(@ModelAttribute("UserEducationalDetails") UserEducationalDetails userEducationalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		completeProfileImpl.saveEducationalDetails(userEducationalDetails);
		System.out.println("saveUserEducationalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserProfessionalDetails", "message", "Your Educational Details have been saved successfully");
		
	}
	
	@RequestMapping(value = "/UserProfessionalDetails", method = RequestMethod.POST)
	public ModelAndView saveUserProfessionalDetails(@ModelAttribute("UserProfessionalDetails") UserProfessionalDetails userProfessionalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		completeProfileImpl.saveProfessionalDetails(userProfessionalDetails);
		System.out.println("saveUserProfessionalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserProfessionalDetails", "message", "Your Professional Details have been saved successfully");
		
	}
	
}
