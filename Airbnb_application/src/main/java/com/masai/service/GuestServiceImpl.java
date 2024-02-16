package com.masai.service;

import java.util.List;
import java.util.Optional;

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
		
		if(guestRepository.existsById(guest.getGuestId())) {
			
			throw new GuestException("Guest already exists with id "+guest.getGuestId());
			
		}
		
		return guestRepository.save(guest);
	}

	@Override
	public Guest getGuestById(int guestId) throws GuestException {
		
		if(!guestRepository.existsById(guestId)) {
			throw new GuestException("Guest doesn't exists with id "+guestId);
		}
		
		Optional<Guest> guest = guestRepository.findById(guestId);
		
		return guest.get();
	}

	@Override
	public List<Guest> getAllGuest() throws GuestException {
		
		List<Guest> list = guestRepository.findAll();
		
		if(list.size() < 1) {
			
			throw new GuestException("No exists");
			
		}
		
		return list;
	}

	@Override
	public Guest updateGuestById(int guestId,Guest updatedGuest) throws GuestException {
		
		if(!guestRepository.existsById(guestId)) {
			throw new GuestException("Guest not found with id "+guestId);
		}
		
		Optional<Guest> guest = guestRepository.findById(guestId);
		
		Guest g = guest.get();
		
		g.setName(updatedGuest.getName());
		g.setGender(updatedGuest.getGender());
		g.setDob(updatedGuest.getDob());
		g.setBio(updatedGuest.getBio());
		
		return guestRepository.save(g);
	}

	@Override
	public String deleteGuestById(int guestId) throws GuestException {
		
		if(!guestRepository.existsById(guestId)) {
			throw new GuestException("Guest not found with id "+guestId);
		}
		
		Optional<Guest> guest = guestRepository.findById(guestId);
		
		guestRepository.delete(guest.get());
		
		return "guest deleted successfully";
	}
	
}
