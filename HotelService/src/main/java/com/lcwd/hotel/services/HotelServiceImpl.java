package com.lcwd.hotel.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repository.HotelRepository;


@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		
		String randomHotelId = UUID.randomUUID().toString();
		System.out.println(hotel.getName());
		hotel.setHotelId(randomHotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id "+id+" not found!!"));
	}

}
