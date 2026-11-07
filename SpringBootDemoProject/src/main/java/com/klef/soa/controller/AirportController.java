package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.dto.AirportRequest;
import com.klef.soa.entity.Airport;
import com.klef.soa.service.AirportService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/airport")
public class AirportController 
{
	 @Autowired
	 private AirportService service;
	 
     @GetMapping("/")
     public String home()
     {
    	 return "Airport Service Project";
     }
     
     @PostMapping("/add")
     public ResponseEntity<Airport> addairport( @Valid @RequestBody AirportRequest request)
     {
    	 return new ResponseEntity<>(service.addAirport(request), HttpStatus.CREATED);
     }
     
     @GetMapping("/displayall")
     public ResponseEntity<List<Airport>> displayAllAirports()
     {
    	 return ResponseEntity.ok(service.displayAllAirports());
     }
     
     @GetMapping("/display/{id}")
     public ResponseEntity<?> displayAirport(@PathVariable Long id)
     {
         Airport a = service.displayAirportById(id);
         if(a != null)
         {
             return ResponseEntity.ok().body(a);
         }
         else
         {
             return ResponseEntity.ok().body("Airport Id Not Found");
         }
     }
     
     @GetMapping("/display/name/{name}")
     public ResponseEntity<List<Airport>> displayAirportByName(@PathVariable String name)
     {
    	 return ResponseEntity.ok(service.displayAirportByName(name));
     }
     
     @GetMapping("/display/type/{type}")
     public ResponseEntity<List<Airport>> displayAirportByType(@PathVariable String type)
     {
    	 return ResponseEntity.ok(service.displayAirportByType(type));
     }
     
     @PutMapping("update/{airportId}")
     public ResponseEntity<String> updateAirport(@PathVariable Long airportId,@Valid @RequestBody AirportRequest request) 
     {
          return ResponseEntity.ok( service.updateAirport(airportId, request));
     }
     
     @DeleteMapping("/delete/{airportId}")
     public ResponseEntity<?> deleteAirport(@PathVariable Long airportId)
     {
         String msg = service.deleteAirportById(airportId);
         if(msg != null)
         {
             return ResponseEntity.ok().body(msg);
         }
         else
         {
             return ResponseEntity.ok().body("Airport Id Not Found");
         }
     }
     
     @GetMapping("/count")
 	 public ResponseEntity<String> displayAirportCount()
 	 {
 		Long count = service.displayAirportCount();
 		String msg = "Total Airports="+count;
 		return ResponseEntity.ok(msg);
 	}
     
     
     
}
