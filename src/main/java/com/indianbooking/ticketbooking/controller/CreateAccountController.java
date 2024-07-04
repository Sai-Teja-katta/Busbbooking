package com.indianbooking.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.indianbooking.ticketbooking.Entity.UserEntity.UserDetails;
import com.indianbooking.ticketbooking.Service.UserDetailsService;

import jakarta.validation.Valid;

@Controller
public class CreateAccountController {
	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;
	public UserDetailsService userDetailsService;

	public CreateAccountController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

//	 @InitBinder
//	    public void initBinder(WebDataBinder dataBinder) {
//
//	        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//
//	        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//	    }
//	 
	@GetMapping("/create_account")
	public String newAccount(Model model) {
		model.addAttribute("userdetails", new UserDetails());
		System.out.println();
		return "create_account";
	}

	@PostMapping("/save_details")
	public String saveUserDetails(@Valid @ModelAttribute("userdetails") UserDetails userDetails,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "create_account";
		}
		String newpassword = bCryptPasswordEncoder.encode(userDetails.getPassword());
		userDetails.setPassword(newpassword);

		userDetailsService.save(userDetails);
		return "login";
	}
}
