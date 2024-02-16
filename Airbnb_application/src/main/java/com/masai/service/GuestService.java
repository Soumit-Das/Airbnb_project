package com.masai.service;

import com.masai.exception.GuestException;
import com.masai.model.Guest;
import java.util.*;

public interface GuestService {

	// add User
	// get User By id 
	// get All Users 
	// update User By id 
	// delete User By id
	
	public Guest createGuest(Guest guest) throws GuestException;
	
	public Guest getGuestById(int guestId) throws GuestException;
	
	public List<Guest> getAllGuest() throws GuestException;
	
	public Guest updateGuestById(int guestId) throws GuestException;
	
	public String deleteGuestById(int guestId) throws GuestException;
	
	
}
