package com.lcwd.rating.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entities.Rating;

@Service
public interface RatingService extends JpaRepository<Rating, String> {
	
	//create
	Rating saveRating(Rating rating);
	
	//get all user
	List<Rating> getRatings();
	
	//get all by user by id
	List<Rating> getRatingByUserId(String userId);
	
	//get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);
	
	//delete
	
	//update

}
