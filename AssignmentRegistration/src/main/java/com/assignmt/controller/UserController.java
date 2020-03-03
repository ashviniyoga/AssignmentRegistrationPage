package com.assignmt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assignmt.Model.User;
import com.assignmt.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView mvreg = new ModelAndView();
		User user = new User();
		mvreg.addObject("user",user);
		System.out.println("Inside the registration ()");
		mvreg.setViewName("user/register");
		return mvreg;
	}
	
	@RequestMapping(value = {"/", "/login"}, method=RequestMethod.GET)
	public ModelAndView login() {
	ModelAndView mvlogin = new ModelAndView();
	mvlogin.setViewName("user/login");	
	System.out.println("In the login ()");
	return mvlogin;
	}
	
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public ModelAndView createUser(@Valid User user, BindingResult bindingresult) {
		ModelAndView mvreg = new ModelAndView();
		User userExists = userservice.findByUserName(user.getUserName());
		
		if(userExists!=null) {
			bindingresult.rejectValue("userName","error.user","This already exists with username");
		}
		if(bindingresult.hasErrors()) {
			mvreg.setViewName("user/registration");
		}
		else {
			userservice.save(userExists);
			mvreg.addObject("msg", "User regitered successfully");
			mvreg.addObject("user", new User());
			mvreg.setViewName("user/registration");
		}
		 
		return mvreg;
	}	
//	@RequestMapping(value= {"\home"), method=RequestMethod.GET)
//	public ModelAndView home() {
//		ModelAndView mvhome = new ModelAndView();
//		mvhome.
//	}
	
}
