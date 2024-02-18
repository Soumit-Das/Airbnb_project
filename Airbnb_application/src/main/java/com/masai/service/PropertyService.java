package com.masai.service;

import java.util.*;

import com.masai.exception.PropertyException;
import com.masai.model.Property;
import com.masai.model.PropertyTypeEnum;

public interface PropertyService {

	// Add property : 
	// Get property by id : 
	// Get All Properties : 
	// Update property by Id
	// Delete property By Id : 
	// Get Property By Name : 
	// Filter properties by location && number of guest && check-in and checkout date :
	// Delete a existing property
	// Update a existing property
	// Filter by price
	// Filter by property type
	// Filter by price and property type
	// Sort by price low to high
	// Sort by price high to low
	
	public Property createProperty(Property property) throws PropertyException;
	
	public Property getPropertById(int propertyId) throws PropertyException;
	
	public List<Property> getAllProperties() throws PropertyException;
	
	public Property updatePropertyById(int propertyId,Property property) throws PropertyException;
	
	public String deletePropertyById(int propertyId) throws PropertyException;
	
	public Property getPropertyByName(String propertyName) throws PropertyException;
	
	public List<Property> getPropertiesByLocationAndNumberofGuest(Integer pageNumber, Integer NumberofRecords,String location,int numberOfGuest) throws PropertyException;
	
	public List<Property> searchByPriceRangeAndType(String propertyType, double startingPrice, double endingPrice) throws PropertyException;
	
	public List<Property> getSortedPropertyTypeListPageWise(Integer pageNumber, Integer NumberofRecords, String propertyType,
			String direction, String field);
	
}
