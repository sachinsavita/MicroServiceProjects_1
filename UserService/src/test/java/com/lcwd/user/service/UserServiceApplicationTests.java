package com.lcwd.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lcwd.user.entities.Rating;
import com.lcwd.user.external_services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RatingService ratingService;
	
	@Test
	void createRating() {
		Rating rating=Rating.builder().rating(10).userId("").hotelId("").feedback("This is greate hotel foe meetings!").build();
		Rating savedRating = ratingService.createRating(rating);
		System.out.println(savedRating);
		
	}

}
