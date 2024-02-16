package com.masai.model;

import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Property {

	// Each Property is linked to a single Host, but a Host may manage multiple Properties, forming a one-to-many relationship.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyId;
	
	private String image;
	
	private String propertyName;
	
	@Enumerated(EnumType.STRING)
	private PropertyTypeEnum propertyType;
	
	private String location;
	
	private int capacity;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "hostId")
	private Host host;
	
	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
	private List<Booking> bookings;
	
}
