package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> 
{
	List<Airport> findByName(String name);
	
	List<Airport> findByType(String type);

}
