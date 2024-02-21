package com.lcwd.rating.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
	
    private String hotelId;
	
	private String name;
	
	private String location;
	
	private String about;

}
