package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.masai.model.Booking;
import java.util.*;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

	@Query("SELECT b FROM Booking b JOIN b.property p WHERE p.location = ?1")
	public List<Booking> findByLocation(String location);
	
	@Query("SELECT b FROM Booking b WHERE b.guest.guestId = ?1")
	public List<Booking> findBookingsHistoryByGuestId(int guestId);
	
	
}
