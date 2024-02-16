package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.masai.service.PropertyService;

@Controller
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	
}
