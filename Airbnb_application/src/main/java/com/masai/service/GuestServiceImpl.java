package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.GuestException;
import com.masai.model.Guest;
import com.masai.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestRepository guestRepository;

	@Override
	public Guest createGuest(Guest guest) throws GuestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guest getGuestById(int guestId) throws GuestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Guest> getAllGuest() throws GuestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guest updateGuestById(int guestId) throws GuestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteGuestById(int guestId) throws GuestException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
