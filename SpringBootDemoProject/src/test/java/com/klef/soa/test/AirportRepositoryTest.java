package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Airport;
import com.klef.soa.repository.AirportRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AirportRepositoryTest
{
    @Autowired
    private AirportRepository repository;

    @Test
    void testFindAllAirports()
    {
        List<Airport> airports = repository.findAll();
        assertNotNull(airports);
        assertFalse(airports.isEmpty());
        System.out.println("Total Airports: " + airports.size());
    }

    @Test
    void testFindAirportById()
    {
        Optional<Airport> airport = repository.findById(1L);
        assertTrue(airport.isPresent());
        assertEquals(1L, airport.get().getAirportId());
        System.out.println("Airport Name: " + airport.get().getName());
    }

    @Test
    void testFindAirportByInvalidId()
    {
        Optional<Airport> airport = repository.findById(999L);
        assertFalse(airport.isPresent());
    }

    @Test
    void testFindAirportByName()
    {
        List<Airport> airports = repository.findByName("Rajiv Gandhi International Airport");
        assertFalse(airports.isEmpty());
        assertEquals("Rajiv Gandhi International Airport", airports.get(0).getName());
        System.out.println("Airport Name: " + airports.get(0).getName());
    }

    @Test
    void testFindAirportByType()
    {
        List<Airport> airports = repository.findByType("International");
        assertNotNull(airports);
        assertFalse(airports.isEmpty());
        assertEquals("International", airports.get(0).getType());
    }

    @Test
    void testAirportCount()
    {
        long count = repository.count();
        assertEquals(2L, count);
        System.out.println("Total Airports: " + count);
    }

    @Test
    void testAirportDetails()
    {
        Optional<Airport> airport = repository.findById(1L);
        assertTrue(airport.isPresent());
        Airport foundAirport = airport.get();
        assertNotNull(foundAirport.getName());
        assertNotNull(foundAirport.getType());
        assertNotNull(foundAirport.getLocation());
        System.out.println("Name: " + foundAirport.getName());
        System.out.println("Type: " + foundAirport.getType());
        System.out.println("Location: " + foundAirport.getLocation());
        System.out.println("Status: " + foundAirport.isStatus());
    }
}
