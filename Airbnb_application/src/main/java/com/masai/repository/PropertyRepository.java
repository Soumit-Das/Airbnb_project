package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.masai.model.Property;
import com.masai.model.PropertyTypeEnum;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>, PagingAndSortingRepository<Property, Integer>{

	
	@Query("SELECT p FROM Property p WHERE p.propertyName = ?1")
	public Property findPropertyByName(String propertyName);
	
	@Query("SELECT p FROM Property p WHERE p.location = ?1 AND p.capacity = ?2")
	Page<Property> findPropertiesByLocationAndNumberofGuestPageWise(String location,int capacity,Pageable p);
	
	
	@Query("SELECT p FROM Property p WHERE p.propertyType = ?1 AND p.price BETWEEN ?2 AND ?3")
	List<Property> findByPriceRangeAndType(String propertyType, double startingPrice, double endingPrice);

	
	@Query("SELECT p FROM Property p WHERE p.propertyType = ?1")
	List<Property> findByType(String propertyType, Sort sort);

	@Query("SELECT p FROM Property p WHERE p.propertyType = ?1")
	Page<Property> findByTypeofProperty(String propertyType, Pageable p);
	
	@Query("SELECT p FROM Property p WHERE p.location = ?1 AND p.capacity = ?2 AND p.propertyType = ?3")
	Page<Property> findPropertiesByLocationAndNumberofGuestPageWiseAndType(String location,int capacity,String propertyType,Pageable p);
	
	
}
