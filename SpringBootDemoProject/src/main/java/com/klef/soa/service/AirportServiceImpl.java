package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.dto.AirportRequest;
import com.klef.soa.entity.Airport;
import com.klef.soa.repository.AirportRepository;

@Service
public class AirportServiceImpl implements AirportService
{
    @Autowired
	private AirportRepository repo;
    
	@Override
	public Airport addAirport(AirportRequest request) 
	{
		Airport airport = Airport.builder()
				.name(request.getName())
		        .type(request.getType())
		        .location(request.getLocation())
		        .status(request.getStatus())
		        .build();
		
		return repo.save(airport);
				
	}

	@Override
	public List<Airport> displayAllAirports() 
	{
		return repo.findAll();
	}

	@Override
	public String updateAirport(Long id, AirportRequest request) 
	{
		Optional<Airport> optional = repo.findById(id);

	    if(optional.isPresent()) 
	    {
	        Airport airport = optional.get();

	        airport.setName(request.getName());
	        airport.setType(request.getType());
	        airport.setLocation(request.getLocation());
	        
	        repo.save(airport);
	        return "Airport Updated Successfully";
	        
	    }
	    else
	    {
	        return "Airport ID Not Found to delete";
	    }
	}

	@Override
	public Airport displayAirportById(Long airportId) 
	{
		return repo.findById(airportId).orElse(null);
	}

	@Override
	public String deleteAirportById(Long airportId) 
	{
		boolean status = repo.existsById(airportId);
		if(status)
		{
			repo.deleteById(airportId);
			return "Airport Deleted Successfully";
		}
		else
		{
			return "Airport ID Not found to delete";
		}
	}

	@Override
	public List<Airport> displayAirportByName(String name) 
	{
		return repo.findByName(name);
	}

	@Override
	public List<Airport> displayAirportByType(String type) 
	{
		return repo.findByType(type);
	}

	@Override
	public Long displayAirportCount() 
	{
		return repo.count();
	}
	

}
