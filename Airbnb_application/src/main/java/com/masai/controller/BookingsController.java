package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.exception.BookingsException;
import com.masai.exception.GuestException;
import com.masai.exception.PropertyException;
import com.masai.model.Booking;
import com.masai.model.Guest;
import com.masai.model.Property;
import com.masai.service.BookingsService;
import com.masai.service.GuestService;
import com.masai.service.PropertyService;
import java.util.*;

@Controller
@RequestMapping("/booking")
public class BookingsController {

	@Autowired
	private BookingsService bookingService;
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private GuestService guestService;
	
	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@RequestParam("guestId") int guestId, @RequestParam("propertyId") int propertyId) throws BookingsException,GuestException,PropertyException {

        Guest guest = guestService.getGuestById(guestId);
        Property property = propertyService.getPropertById(propertyId);

        if (guest == null) {
            throw new GuestException("Guest not found with id "+guestId);
        }

        if (property == null) {
            throw new PropertyException("Property not found with id "+propertyId);
        }

        // Create and save the booking
        Booking booking = new Booking();
        booking.setGuest(guest);
        booking.setProperty(property);
        bookingService.createBooking(booking);

        return new ResponseEntity<>(booking,HttpStatus.CREATED);
	}

	@GetMapping("/getBookingByLocation/{location}")
	public ResponseEntity<List<Booking>> getBookingByLocation(@PathVariable String location) throws BookingsException {

		List<Booking> cat = bookingService.getBookingsByLocation(location);
		return new ResponseEntity<>(cat, HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookings")
	public ResponseEntity<List<Booking>> getAllBookings() throws BookingsException{
		
		List<Booking> cat = bookingService.getAllBookings();
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	@GetMapping("/getBookingsHistoryByGuestId/{userId}")
	public ResponseEntity<List<Booking>> getBookingsHistoryByGuestId(@PathVariable int userId) throws GuestException{
		
		List<Booking> cat = bookingService.getBookingsHistoryByGuestId(userId);
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteBooking/{bookingId}")
	public ResponseEntity<String> deleteBooking(@PathVariable int bookingId) throws BookingsException{
		
		String cat = bookingService.deleteBooking(bookingId);
		return new ResponseEntity<>(cat,HttpStatus.OK);
		
	}
	
	
}
