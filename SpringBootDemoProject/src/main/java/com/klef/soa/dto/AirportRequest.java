package com.klef.soa.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AirportRequest 
{
	@NotBlank(message = "Name is Required")
	private String name;
	
	@NotBlank(message = "Type is Required")
	private String type;
	
	@NotBlank(message = "Location is Required")
	private String location;
	
	private Boolean status;
}
