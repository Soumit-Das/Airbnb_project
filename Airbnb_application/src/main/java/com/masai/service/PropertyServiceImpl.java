package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.PropertyException;
import com.masai.model.Property;
import com.masai.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService{

	@Autowired
	private PropertyRepository propertyRepository;

	@Override
	public Property createProperty(Property property) throws PropertyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property getPropertById(int propertyId) throws PropertyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Property> getAllProperties() throws PropertyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property updatePropertyById(int propertyId) throws PropertyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePropertyById(int propertyId) throws PropertyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property getPropertyByName(String propertyName) throws PropertyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Property> getPropertiesByLocationAndNumberofGuest(String location, int numberOfGuest)
			throws PropertyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Property> searchByPriceRangeAndType(String propertyType, double startingPrice, double endingPrice)
			throws PropertyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Property> getSortedPropertyTypeListPageWise(Integer pageNumber, Integer NumberofRecords, String Type,
			String direction, String field) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
