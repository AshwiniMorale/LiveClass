package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserEducationalDetails;
import com.bean.UserPersonalDetails;
import com.bean.UserProfessionalDetails;
import com.daoImpl.UserEducationalDetailsImpl;
import com.daoImpl.UserPersonalDetailsImpl;
import com.daoImpl.UserProfessionalDetailsImpl;

@Controller
public class CompleteProfileController {

	int userId = 0;
	static final String MESSAGE = "message";

	@Autowired
	UserPersonalDetailsImpl userPersonalDetailsImpl;
	@Autowired
	UserEducationalDetailsImpl userEducationalDetailsImpl;
	@Autowired
	UserProfessionalDetailsImpl userProfessionalDetailsImpl;

	@PostMapping("/saveuserpersonal")
	public ModelAndView saveUserPersonalDetails(
			@ModelAttribute("UserPersonalDetails") UserPersonalDetails userPersonalDetails, HttpServletRequest req,
			HttpServletResponse res) {
		System.out.println(":: saveUserPersonalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		System.out.println("userId from sessiom:-->" + userId);
		userPersonalDetails.setUserId(userId);
		userPersonalDetailsImpl.saveUserPersonalDetails(userPersonalDetails);
		return new ModelAndView("usr-educational", MESSAGE, "Your Personal Details have been saved successfully");
	}

	@PostMapping("/readuserpersonal")
	public ModelAndView readUserPersonalDetails(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(":: readUserPersonalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		userPersonalDetailsImpl.readUserPersonalDetails(userId);
		return new ModelAndView("#", MESSAGE, "Your Personal Details have been saved successfully");
	}

	@PostMapping("/updateuserpersonal")
	public ModelAndView updateUserPersonalDetails(
			@ModelAttribute("UserPersonalDetails") UserPersonalDetails userPersonalDetails, HttpServletRequest req,
			HttpServletResponse res) {
		System.out.println(":: updateUserPersonalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		userPersonalDetails.setUserId(userId);
		userPersonalDetailsImpl.updateUserPersonalDetails(userPersonalDetails);
		return new ModelAndView("#", MESSAGE, "Your Personal Details have been saved successfully");
	}

	@PostMapping("/deleteuserpersonal")
	public ModelAndView deleteUserPersonalDetails(
			@ModelAttribute("UserPersonalDetails") UserPersonalDetails userPersonalDetails, HttpServletRequest req,
			HttpServletResponse res) {
		System.out.println(":: deleteUserPersonalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		userPersonalDetails.setUserId(userId);
		userPersonalDetailsImpl.updateUserPersonalDetails(userPersonalDetails);
		return new ModelAndView("#", MESSAGE, "Your Personal Details have been saved successfully");
	}

	@PostMapping("/saveusereducational")
	public ModelAndView saveUserEducationalDetails(
			@ModelAttribute("UserEducationalDetails") UserEducationalDetails userEducationalDetails,
			HttpServletRequest req, HttpServletResponse res) {
		System.out.println(":: saveUserEducationalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		userEducationalDetails.setUserId(userId);
		userEducationalDetailsImpl.saveUserEducationalDetails(userEducationalDetails);
		return new ModelAndView("usr-professional", MESSAGE, "Your Educational Details have been saved successfully");
	}

	@PostMapping("/readusereducationalDetails")
	public ModelAndView readUserEducationalDetails(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(":: readUserEducationalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		userEducationalDetailsImpl.readUserEducationalDetails(userId);
		return new ModelAndView("#", MESSAGE, "Your Educational Details have been saved successfully");
	}

	@PostMapping("/updateusereducational")
	public ModelAndView updateUserEducationalDetails(
			@ModelAttribute("UserEducationalDetails") UserEducationalDetails userEducationalDetails,
			HttpServletRequest req, HttpServletResponse res) {
		System.out.println(":: updateUserEducationalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		userEducationalDetails.setUserId(userId);
		userEducationalDetailsImpl.updateUserEducationalDetails(userEducationalDetails);
		return new ModelAndView("#", MESSAGE, "Your Educational Details have been saved successfully");
	}

	@PostMapping("/deleteusereducational")
	public ModelAndView deleteUserEducationalDetails(
			@ModelAttribute("UserEducationalDetails") UserEducationalDetails userEducationalDetails,
			HttpServletRequest req, HttpServletResponse res) {
		System.out.println(":: deleteUserEducationalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		userEducationalDetails.setUserId(userId);
		userEducationalDetailsImpl.deleteUserEducationalDetails(userEducationalDetails);
		return new ModelAndView("UserProfessionalDetails", "message",
				"Your Educational Details have been saved successfully");

	}

	@PostMapping("/saveuserprofessional")
	public ModelAndView saveUserProfessionalDetails(
			@ModelAttribute("UserProfessionalDetails") UserProfessionalDetails userProfessionalDetails,
			HttpServletRequest req, HttpServletResponse res) {
		System.out.println(":: saveUserProfessionalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		userProfessionalDetails.setUserId(userId);
		userProfessionalDetailsImpl.saveUserProfessionalDetails(userProfessionalDetails);
		return new ModelAndView("login", MESSAGE, "Your Professional Details have been saved successfully");

	}

	@PostMapping("/readuserprofessional")
	public ModelAndView readUserProfessionalDetails(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(":: readUserProfessionalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		userProfessionalDetailsImpl.readUserProfessionalDetails(userId);
		return new ModelAndView("#", MESSAGE, "Your Professional Details have been saved successfully");
	}

	@PostMapping("/updateuserprofessional")
	public ModelAndView updateUserProfessionalDetails(
			@ModelAttribute("UserProfessionalDetails") UserProfessionalDetails userProfessionalDetails,
			HttpServletRequest req, HttpServletResponse res) {
		System.out.println(":: updateUserProfessionalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		userProfessionalDetails.setUserId(userId);
		userProfessionalDetailsImpl.updateUserProfessionalDetails(userProfessionalDetails);
		return new ModelAndView("#", MESSAGE, "Your Professional Details have been saved successfully");
	}

	@PostMapping("/deleteserrofessional")
	public ModelAndView deleteUserProfessionalDetails(
			@ModelAttribute("UserProfessionalDetails") UserProfessionalDetails userProfessionalDetails,
			HttpServletRequest req, HttpServletResponse res) {
		System.out.println(":: deleteUserProfessionalDetails() called:-->CompleteProfileController");
		HttpSession httpSession = req.getSession();
		userId = (int) httpSession.getAttribute("userId");
		userProfessionalDetails.setUserId(userId);
		userProfessionalDetailsImpl.deleteUserProfessionalDetails(userProfessionalDetails);
		return new ModelAndView("#", MESSAGE, "Your Professional Details have been saved successfully");
	}
}
