  package com.lcwd.user.external_services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lcwd.user.entities.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	
	//get
	@GetMapping("/ratings/{ratingId}")
	public Rating getRating(@PathVariable String ratingId);
	
	//Post
	@PostMapping("/ratings")
	public Rating createRating(Rating rating);
	
	//Put
	@PutMapping("/ratings/{ratingid}")
	public Rating updateRating(@PathVariable String ratingId);
	
	//Delete
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
}

