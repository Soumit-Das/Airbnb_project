package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Host {

	//Name (Text), Host Status (Checkbox: Active/Inactive), Location (Text), Property Type (Dropdown: Apartment, House, Unique Homes), About (Textarea), Hosting Since (Date).
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hostId; 
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private StatusEnumType status;
	
	private String location;

	private String about;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate hostingSince;
	
	@OneToMany(mappedBy = "host" , cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Property> properties; 
	
	
}
