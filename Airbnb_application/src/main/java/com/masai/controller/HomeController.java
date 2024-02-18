package com.masai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		
		return "index";
		
	}
	
	
	
	@GetMapping("/hostLogin")
	public String hostLogin() {
		
		return "Login";
		
	}
	
	@GetMapping("/hostProfile")
	public String hostProfile() {
		
		return "host_profile";
		
	}
	
	@GetMapping("/propertyListings")
	public String propertyListings() {
		
		return "Property_listings";
		
	}
	
	@GetMapping("/property/propertyDetails")
	public String propertyDetails() {
		
		return "Property_details";
		
	}
	
}
