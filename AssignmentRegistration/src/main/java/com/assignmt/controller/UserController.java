package com.assignmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.assignmt.Model.User;
import com.assignmt.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}
	

}
