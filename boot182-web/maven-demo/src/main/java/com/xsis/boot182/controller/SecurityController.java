package com.xsis.boot182.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	@RequestMapping("/login.html")
	public String loginForm() {
		return "login";
	}

	@RequestMapping("/home.html")
	public String home() {
		return "home";
	}

	@RequestMapping("/403.html")
	public String accessDenied() {
		return "403";
	}
}
