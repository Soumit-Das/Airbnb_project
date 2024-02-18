package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		if(bookingRepository.existsById(booking.getBookingId())) {
			throw new BookingsException("booking already exists");
		}
		
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getBookingsByLocation(String location) throws BookingsException {
		
		List<Booking> list = bookingRepository.findByLocation(location);
//		List<Booking> list = new ArrayList<>();
		
		if(list.size() < 1) {
			throw new BookingsException("No bookings are present in "+location);
		}
		
		return list;
	}

	@Override
	public List<Booking> getAllBookings() throws BookingsException {
		
		List<Booking> list = bookingRepository.findAll();
		
		if(list.size() < 1) {
			throw new BookingsException("No bookings are present");
		}
		
		return list;
	}

	@Override
	public List<Booking> getBookingsHistoryByGuestId(int guestId) throws GuestException {
		
		List<Booking> list = bookingRepository.findBookingsHistoryByGuestId(guestId);
//		List<Booking> list = new ArrayList<>();
		if(list.size() < 1) {
			throw new GuestException("No bookings are present for the guest");
		}
		
		return list;
	}

	@Override
	public String deleteBooking(int bookingId) throws BookingsException {
		
		Optional<Booking> booking = bookingRepository.findById(bookingId);

		if (booking.isEmpty()) {
			throw new BookingsException("No booking exists with id " + bookingId);
		}

		bookingRepository.delete(booking.get());

		return "Booking deleted successfully";

	}
	
	
	
}
