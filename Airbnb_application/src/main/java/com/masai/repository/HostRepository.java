package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.Host;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer>{

	@Query("SELECT h FROM Host h LEFT JOIN FETCH h.properties WHERE h.hostId = :hostId")
    Optional<Host> findByIdWithProperties(@Param("hostId") int hostId);
	
}
