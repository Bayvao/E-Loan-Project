package com.elaon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/showLoginPage")
	public String showMyLoginPage() {
		
		return "login";
		
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		
		String redirect;
		
		if(request.isUserInRole("ADMIN")) {
			redirect = "redirect:/admin/admin-home";
		}else {
			redirect = "home";
		}
		
		return redirect;
	}
	
	@GetMapping("/showManagerPage")
	public String managerHome() {
		return "manager-home";
	}
	
}
