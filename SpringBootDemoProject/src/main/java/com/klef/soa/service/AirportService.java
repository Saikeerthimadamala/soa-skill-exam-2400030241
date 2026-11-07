package com.klef.soa.service;

import java.util.List;

import com.klef.soa.dto.AirportRequest;
import com.klef.soa.entity.Airport;

public interface AirportService 
{
	Airport addAirport(AirportRequest request);
	List<Airport> displayAllAirports();
	String updateAirport(Long id, AirportRequest request);
	Airport displayAirportById(Long airportId);
	String deleteAirportById(Long airportId);
	List<Airport> displayAirportByName(String name);
	List<Airport> displayAirportByType(String type);
	Long displayAirportCount();
}
