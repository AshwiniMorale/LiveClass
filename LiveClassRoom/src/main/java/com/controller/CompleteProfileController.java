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
import com.daoImpl.UserEducationalDetailsImpl;
import com.daoImpl.UserPersonalDetailsImpl;
import com.daoImpl.UserProfessionalDetailsImpl;

@Controller
public class CompleteProfileController {

	int userId=0;
	UserPersonalDetailsImpl userPersonalDetailsImpl=new UserPersonalDetailsImpl();
	UserEducationalDetailsImpl userEducationalDetailsImpl= new UserEducationalDetailsImpl();
	UserProfessionalDetailsImpl userProfessionalDetailsImpl= new UserProfessionalDetailsImpl();

	
	//Methods Of UserPersonalDetailsImpl is being called:
	
	@RequestMapping(value = "/UserPersonalDetails", method = RequestMethod.POST)
	public ModelAndView saveUserPersonalDetails(@ModelAttribute("UserPersonalDetails") UserPersonalDetails userPersonalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		userPersonalDetailsImpl.saveUserPersonalDetails(userPersonalDetails);
		System.out.println("saveUserPersonalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserEducationalDetails", "message", "Your Personal Details have been saved successfully");
		
	}
	

	@RequestMapping(value = "/UserPersonalDetails", method = RequestMethod.POST)
	public ModelAndView readUserPersonalDetails(HttpServletRequest req, HttpServletResponse res)
	{
		userPersonalDetailsImpl.readUserPersonalDetails(userId);
		System.out.println("readUserPersonalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserEducationalDetails", "message", "Your Personal Details have been saved successfully");
		
	}
	
	@RequestMapping(value = "/UserPersonalDetails", method = RequestMethod.POST)
	public ModelAndView updateUserPersonalDetails(@ModelAttribute("UserPersonalDetails") UserPersonalDetails userPersonalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		userPersonalDetailsImpl.updateUserPersonalDetails(userPersonalDetails, userId);
		System.out.println("updateUserPersonalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserEducationalDetails", "message", "Your Personal Details have been saved successfully");
		
	}
	
	@RequestMapping(value = "/UserPersonalDetails", method = RequestMethod.POST)
	public ModelAndView deleteUserPersonalDetails(@ModelAttribute("UserPersonalDetails") UserPersonalDetails userPersonalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		userPersonalDetailsImpl.updateUserPersonalDetails(userPersonalDetails, userId);
		System.out.println("updateUserPersonalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserEducationalDetails", "message", "Your Personal Details have been saved successfully");
		
	}
	
	
	//Methods Of UserEducationalDetailsImpl is being called:
	
    @RequestMapping(value = "/UserEducationalDetails", method = RequestMethod.POST)
	public ModelAndView saveUserEducationalDetails(@ModelAttribute("UserEducationalDetails") UserEducationalDetails userEducationalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		userEducationalDetailsImpl.saveUserEducationalDetails(userEducationalDetails);
		System.out.println("saveUserEducationalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserProfessionalDetails", "message", "Your Educational Details have been saved successfully");
		
	}
	
	@RequestMapping(value = "/UserEducationalDetails", method = RequestMethod.POST)
	public ModelAndView readUserEducationalDetails(HttpServletRequest req, HttpServletResponse res)
	{
		userEducationalDetailsImpl.readUserEducationalDetails(userId);
		System.out.println("readUserEducationalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserProfessionalDetails", "message", "Your Educational Details have been saved successfully");
		
	}
	
	
	@RequestMapping(value = "/UserEducationalDetails", method = RequestMethod.POST)
	public ModelAndView updateUserEducationalDetails(@ModelAttribute("UserEducationalDetails") UserEducationalDetails userEducationalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		userEducationalDetailsImpl.updateUserEducationalDetails(userEducationalDetails,userId);
		System.out.println("updateUserEducationalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserProfessionalDetails", "message", "Your Educational Details have been saved successfully");
		
	}
	@RequestMapping(value = "/UserEducationalDetails", method = RequestMethod.POST)
	public ModelAndView deleteUserEducationalDetails(@ModelAttribute("UserEducationalDetails") UserEducationalDetails userEducationalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		userEducationalDetailsImpl.deleteUserEducationalDetails(userEducationalDetails, userId);
		System.out.println("saveUserEducationalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserProfessionalDetails", "message", "Your Educational Details have been saved successfully");
		
	}
	
	
	//Methods Of UserProfessionalDetailsImpl is being called:
	
	@RequestMapping(value = "/UserProfessionalDetails", method = RequestMethod.POST)
	public ModelAndView saveUserProfessionalDetails(@ModelAttribute("UserProfessionalDetails") UserProfessionalDetails userProfessionalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		userProfessionalDetailsImpl.saveUserProfessionalDetails(userProfessionalDetails);
		System.out.println("saveUserProfessionalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserProfessionalDetails", "message", "Your Professional Details have been saved successfully");
		
	}
	
	@RequestMapping(value = "/UserProfessionalDetails", method = RequestMethod.POST)
	public ModelAndView readUserProfessionalDetails(HttpServletRequest req, HttpServletResponse res)
	{
		userProfessionalDetailsImpl.readUserProfessionalDetails(userId);
		System.out.println("readUserProfessionalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserProfessionalDetails", "message", "Your Professional Details have been saved successfully");
		
	}
	
	@RequestMapping(value = "/UserProfessionalDetails", method = RequestMethod.POST)
	public ModelAndView updateUserProfessionalDetails(@ModelAttribute("UserProfessionalDetails") UserProfessionalDetails userProfessionalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		userProfessionalDetailsImpl.updateUserProfessionalDetails(userProfessionalDetails, userId);
		System.out.println("updateUserProfessionalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserProfessionalDetails", "message", "Your Professional Details have been saved successfully");
		
	}
	
	@RequestMapping(value = "/UserProfessionalDetails", method = RequestMethod.POST)
	public ModelAndView deleteUserProfessionalDetails(@ModelAttribute("UserProfessionalDetails") UserProfessionalDetails userProfessionalDetails, HttpServletRequest req, HttpServletResponse res)
	{
		userProfessionalDetailsImpl.deleteUserProfessionalDetails(userProfessionalDetails, userId);
		System.out.println("deleteUserProfessionalDetails:: CompleteProfile controller called.");
		return new ModelAndView("UserProfessionalDetails", "message", "Your Professional Details have been saved successfully");
		
	}
	
}
