package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.exception.HostException;
import com.masai.exception.PropertyException;
import com.masai.model.Guest;
import com.masai.model.Host;
import com.masai.model.Property;
import com.masai.model.PropertyTypeEnum;
import com.masai.service.HostService;
import com.masai.service.PropertyService;

@Controller
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	@Autowired
	private HostService hostService;
	
	@PostMapping("/createProperty")
    public ResponseEntity<Property> createProperty(@RequestBody Property property, @RequestParam("hostId") int hostId) throws HostException, PropertyException {
 
        Host host = hostService.getHostById(hostId);
        if (host == null) {
            throw new HostException("Host not found with id "+hostId);
        }


        property.setHost(host);


        Property createdProperty = propertyService.createProperty(property);

        return new ResponseEntity<>(createdProperty, HttpStatus.CREATED);
    }
	
	@GetMapping("/getPropertById/{propertyId}")
	public ResponseEntity<Property> getPropertById(@PathVariable int propertyId) throws PropertyException{
		
		Property cat = propertyService.getPropertById(propertyId);
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllProperties")
	public ResponseEntity<List<Property>> getAllProperties() throws PropertyException{
		
		List<Property> list = propertyService.getAllProperties();
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/updatePropertyById/{propertyId}")
	public ResponseEntity<Property> updatePropertyById(@PathVariable int propertyId,@RequestBody Property property) throws PropertyException{
		
		Property cat = propertyService.updatePropertyById(propertyId,property);
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deletePropertyById/{propertyId}")
	public ResponseEntity<String> deletePropertyById(@PathVariable int propertyId) throws PropertyException{
		
		String cat = propertyService.deletePropertyById(propertyId);
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	@GetMapping("/getPropertyByName/{propertyName}")
	public ResponseEntity<Property> getPropertyByName(@PathVariable String propertyName) throws PropertyException{
		
		Property cat = propertyService.getPropertyByName(propertyName);
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
		
	}
	@GetMapping("/getPropertiesByLocationAndNumberofGuest/{location}/{numberOfGuest}/{pageNumber}")
	public ResponseEntity<List<Property>> getPropertiesByLocationAndNumberofGuest(@PathVariable Integer pageNumber,
			@RequestParam Integer NumberofRecords,@PathVariable String location,@PathVariable int numberOfGuest) throws PropertyException{
		
		List<Property> list = propertyService.getPropertiesByLocationAndNumberofGuest(pageNumber, NumberofRecords, location, numberOfGuest);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/searchByPriceRangeAndType/{propertyType}/{startingPrice}/{endingPrice}")
	public ResponseEntity<List<Property>> searchByPriceRangeAndType(@PathVariable String propertyType,@PathVariable double startingPrice,@PathVariable double endingPrice) throws PropertyException{
		
		List<Property> list = propertyService.searchByPriceRangeAndType(propertyType, startingPrice, endingPrice);
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/getSortedPropertyTypeListPageWise/{propertyType}/{direction}/{field}/{pageNumber}")
	public ResponseEntity<List<Property>> getSortedPropertyTypeListPageWise(@PathVariable Integer pageNumber,@RequestParam Integer NumberofRecords,@PathVariable String propertyType,
			@PathVariable String direction,@PathVariable String field){
		
		List<Property> list = propertyService.getSortedPropertyTypeListPageWise(pageNumber, NumberofRecords, propertyType, direction, field);
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/getPropertiesByLocationAndNumberofGuestAndType/{location}/{numberOfGuest}/{propertyType}/{pageNumber}")
	public ResponseEntity<List<Property>> getPropertiesByLocationAndNumberofGuestAndType(
	        @PathVariable Integer pageNumber,
	        @RequestParam Integer NumberofRecords,
	        @PathVariable String location,
	        @PathVariable int numberOfGuest,
	        @PathVariable String propertyType) throws PropertyException {
	    
	    List<Property> list = propertyService.getPropertiesByLocationAndNumberofGuestandType(
	            pageNumber, NumberofRecords, location, numberOfGuest, propertyType);
	    return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	
}
