package com.rajeev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rajeev.model.User;
import com.rajeev.service.UserService;

@Controller
public class UserController {
   
	@Autowired
	private UserService service;
	
	@GetMapping("/login")
	public String getPage() {
		return "login";
	}
	@PostMapping("/save")
	public String login(@RequestParam String userName,@RequestParam String userPassword,Model model) {
		User user = service.login(userName, userPassword);
		if(user!=null) {
		model.addAttribute("user", user);
			return "welcome";
		}
		model.addAttribute("error", "invalid userName and password");
		return "login";
	}
}
