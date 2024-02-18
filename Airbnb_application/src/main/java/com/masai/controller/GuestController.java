package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.masai.exception.GuestException;
import com.masai.model.Booking;
import com.masai.model.Guest;
import com.masai.service.GuestService;

@Controller
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	private GuestService guestService;
	
	
	@GetMapping("/home")
	public String home() {
		
		return "home";
		
	}
	
	@GetMapping("/profile")
	public String profile() {
		
		return "guest_profile";
		
	}
	
	
	@GetMapping("/propertyListings")
	public String productListings() {
		
		return "Property_listings";
		
	}
	
	
	@GetMapping("/PropertyDetails")
	public String productPage() {
		
		return "Property_details";
		
	}
	
	
	@PostMapping("/createGuest")
	public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) throws GuestException{
		
		Guest cat = guestService.createGuest(guest);
		return new ResponseEntity<>(cat, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getGuestById/{guestId}")
	public ResponseEntity<Guest> getGuestById(@PathVariable int guestId) throws GuestException{
		
		Guest cat = guestService.getGuestById(guestId);
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllGuest")
	public ResponseEntity<List<Guest>> getAllGuest() throws GuestException{
		
		List<Guest> cat = guestService.getAllGuest();
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateGuestById/{guestId}")
	public ResponseEntity<Guest> updateGuestById(@PathVariable int guestId,@RequestBody Guest guest) throws GuestException{
		
		Guest cat = guestService.updateGuestById(guestId,guest);
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteGuestById/{guestId}")
	public ResponseEntity<String> deleteGuestById(@PathVariable int guestId) throws GuestException{
		
		String cat = guestService.deleteGuestById(guestId);
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
}
