package com.masai.service;

import com.masai.exception.BookingsException;
import com.masai.exception.GuestException;
import com.masai.model.Booking;
import java.util.*;

public interface BookingsService {

	/* - See all properties by location (It gives the list of properties for a particular location) (needed                 in the admin section)
	- See all the bookings (needed in the admin section)
	- See all the bookings history by user Id (booking history)
	- Delete booking
	*/
	
	public Booking createBooking(Booking booking) throws BookingsException;
	
	public List<Booking> getBookingsByLocation(String location) throws BookingsException;
	
	public List<Booking> getAllBookings() throws BookingsException;
	
	public List<Booking> getBookingsHistoryByGuestId(int guestId) throws GuestException;
	
	public String deleteBooking(int bookingId) throws BookingsException;
	
}
