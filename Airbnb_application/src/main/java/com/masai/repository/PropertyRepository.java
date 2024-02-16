package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.masai.model.Property;
import java.util.*;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>, PagingAndSortingRepository<Property, Integer>{

	@Query("SELECT p FROM Property p WHERE p.propertyType = ?1 AND p.price BETWEEN ?2 AND ?3")
	List<Property> findByPriceRangeAndType(String productType, double startingPrice, double endingPrice);
	
}
