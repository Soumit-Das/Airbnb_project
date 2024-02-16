package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookingsException;
import com.masai.exception.GuestException;
import com.masai.model.Booking;
import com.masai.repository.BookingRepository;

@Service
public class BookingsServiceImpl implements BookingsService{

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking createBooking(Booking booking) throws BookingsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getBookingsByLocation(String location) throws BookingsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getAllBookings() throws BookingsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getBookingsHistoryByGuestId(int userId) throws GuestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBooking(int bookingId) throws BookingsException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
