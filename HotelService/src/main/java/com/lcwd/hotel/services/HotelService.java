package com.lcwd.hotel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcwd.hotel.entities.Hotel;

@Service
public interface HotelService {
	
	//create
	Hotel saveHotel(Hotel hotel);
	
	//get all hotel
	List<Hotel> getAllHotel();
	
	//single hotel
	Hotel getHotelById(String id);
	
	//delete
	
	//update

}
