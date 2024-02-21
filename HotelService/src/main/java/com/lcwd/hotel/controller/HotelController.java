package com.lcwd.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelService;


@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	
	@GetMapping("/pieChart")
	public ModelAndView pieChart()
	{
		System.out.println("Inside pieChart method");
		ModelAndView mav = new ModelAndView();
		Map<String, Integer> map = new HashMap<>();
		map.put("UP", 2000);
		map.put("Bihar", 1500);
		map.put("MP", 1200);
		map.put("Delhi", 800);
		map.put("Rajasthan", 123);
		
		mav.addObject("values", map);
		mav.setViewName("viewPage");
		return mav;
		
	}
	
	
	//create 
	@PostMapping("/")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel)
	{
		System.out.println("Inside save method");
		Hotel rHotel = hotelService.saveHotel(hotel);
		//return new ResponseEntity<>(HttpStatus.CREATED);
		return ResponseEntity.status(HttpStatus.CREATED).body(rHotel);
	}
	
	//single hotel get
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId)
	{
		Hotel hotel = hotelService.getHotelById(hotelId);
		return new ResponseEntity<>(hotel ,HttpStatus.OK);
	}
	
	//all hotel get
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotel()
	{
		List<Hotel> hotels = hotelService.getAllHotel();
		return ResponseEntity.ok(hotels);
	}
	
	

}
