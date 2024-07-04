package com.indianbooking.ticketbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	@GetMapping("/signin")
	public String getLogin() {
		System.out.println("Here at the place");
		return "login";
	}

}
