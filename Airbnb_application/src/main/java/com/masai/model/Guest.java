package com.masai.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Guest {

	// The application should also facilitate CRUD operations for Guest profiles. Fields include: Name (Text), Gender (Radio: Male/Female/Other), Date of Birth (Date), Bio (Textarea).
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int guestId;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private GenderEnumType gender;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dob;
	
	private String bio;
	
	@OneToMany(mappedBy = "guest",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Booking> bookings;
	
}
