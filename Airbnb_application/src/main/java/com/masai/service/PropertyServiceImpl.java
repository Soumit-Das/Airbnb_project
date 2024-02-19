package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.PropertyException;
import com.masai.model.Property;
import com.masai.model.PropertyTypeEnum;
import com.masai.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService{

	@Autowired
	private PropertyRepository propertyRepository;

	@Override
	public Property createProperty(Property property) throws PropertyException {
		
		if(propertyRepository.existsById(property.getPropertyId())) {
			
			throw new PropertyException("Property already exists with id "+property.getPropertyId());
		}
		
		return propertyRepository.save(property);
	}

	@Override
	public Property getPropertById(int propertyId) throws PropertyException {
		
		if(!propertyRepository.existsById(propertyId)) {
			throw new PropertyException("Property not found with id "+propertyId);
		}
		
		Optional<Property> pro = propertyRepository.findById(propertyId);
		
		return pro.get();
	}

	@Override
	public List<Property> getAllProperties() throws PropertyException {
		
		List<Property> list = propertyRepository.findAll();
		
		if(list.size() < 1) {
			throw new PropertyException("No property found");
		}
		
		
		return list;
	}

	@Override
	public Property updatePropertyById(int propertyId,Property property) throws PropertyException {
		
		if(!propertyRepository.existsById(propertyId)) {
			throw new PropertyException("Property not found with id "+propertyId);
		}
		
		Optional<Property> pro = propertyRepository.findById(propertyId);
		
		Property p = pro.get();
		
		p.setImage(property.getImage());
		p.setPropertyName(property.getPropertyName());
		p.setPropertyType(property.getPropertyType());
		p.setCapacity(property.getCapacity());
		p.setPrice(property.getPrice());
		
		return propertyRepository.save(p);
	}

	@Override
	public String deletePropertyById(int propertyId) throws PropertyException {
		
		if(!propertyRepository.existsById(propertyId)) {
			throw new PropertyException("Property not found with id "+propertyId);
		}
		
		Optional<Property> pro = propertyRepository.findById(propertyId);
		
		propertyRepository.delete(pro.get());
		
		return null;
	}

	@Override
	public Property getPropertyByName(String propertyName) throws PropertyException {
		
		Property prop = propertyRepository.findPropertyByName(propertyName);
		
		if(prop == null) {
			throw new PropertyException("Property not found with name "+propertyName);
		}

		return prop;
	}

	@Override
	public List<Property> getPropertiesByLocationAndNumberofGuest(Integer pageNumber, Integer NumberofRecords,String location, int numberOfGuest)
			throws PropertyException {

		Pageable p = PageRequest.of(pageNumber - 1, NumberofRecords);

		Page<Property> page = propertyRepository.findPropertiesByLocationAndNumberofGuestPageWise(location, numberOfGuest, p);

		List<Property> list = page.getContent();
		
		if(list.isEmpty()) {
			throw new PropertyException("No properties found");
		}
		
		return list;
	}

	@Override
	public List<Property> searchByPriceRangeAndType(String propertyType, double startingPrice, double endingPrice)
			throws PropertyException {
		
		List<Property> prop = propertyRepository.findByPriceRangeAndType(propertyType, startingPrice, endingPrice);
		
		if(prop.isEmpty()) {
			throw new PropertyException("No properties found");
		}
		
		return prop;

	}

	@Override
	public List<Property> getSortedPropertyTypeListPageWise(Integer pageNumber, Integer NumberofRecords, String propertyType,
			String direction, String field) {
		
		Sort sort = direction.equals("asc") ? Sort.by(field).ascending() : Sort.by(field).descending();

		Pageable p = PageRequest.of(pageNumber - 1, NumberofRecords, sort);

		Page<Property> page = propertyRepository.findByTypeofProperty(propertyType, p);

		List<Property> list = page.getContent();

		return list;

	}

	@Override
	public List<Property> getPropertiesByLocationAndNumberofGuestandType(Integer pageNumber, Integer NumberofRecords,
			String location, int numberOfGuest, String propertyType) throws PropertyException {
		
		Pageable p = PageRequest.of(pageNumber - 1, NumberofRecords);

		Page<Property> page = propertyRepository.findPropertiesByLocationAndNumberofGuestPageWiseAndType(location, numberOfGuest, propertyType, p);

		List<Property> list = page.getContent();
		
		if(list.isEmpty()) {
			throw new PropertyException("No properties found");
		}
		
		return list;

	}
	
}
