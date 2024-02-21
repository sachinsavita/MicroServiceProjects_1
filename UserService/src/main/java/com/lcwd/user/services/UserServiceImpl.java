package com.lcwd.user.services;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.entities.Hotel;
import com.lcwd.user.entities.Rating;
import com.lcwd.user.entities.User;
import com.lcwd.user.exceptions.ResourceNotFoundException;
import com.lcwd.user.external_services.HotelService;
import com.lcwd.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Override
	public User saveUser(User user) {
		
		String randomUserId = UUID.randomUUID().toString();
		System.out.println(user.getName());
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String id) {
		
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given id "+id+" not found!!"));
		Rating[]  ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		logger.info("{} ", ratingOfUser);
		List<Rating> ratings =   Arrays.stream(ratingOfUser).toList();
//		Rating rating = new Rating();
//		List<Rating> ratingList = ratings.stream().map(rating -> {
//			ResponseEntit y<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/43ec7ff1-93a0-4f3c-a3f8-f1cba2b57a47", Hotel.class);
//			Hotel hotel = hotelEntity.getBody();
//			rating.setHotel(hotel);
//			return rating;
//		}).collect(Collectors.toList());
		
		Iterator<Rating> iterator = ratings.iterator();
		while (iterator.hasNext()) {
            Rating element = iterator.next();
            
//            ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+element.getHotelId(), Hotel.class);
//			Hotel hotel = hotelEntity.getBody();
            
			Hotel hotel = hotelService.getHotel(element.getHotelId());
            // Set the modified element using the iterator's set method
            element.setHotel(hotel);
        }
		
//		for (Rating rating : ratings) {
//			ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/43ec7ff1-93a0-4f3c-a3f8-f1cba2b57a47", Hotel.class);
//			Hotel hotel = hotelEntity.getBody();
//			rating.setHotel(hotel);
//		}
			
		user.setRatings(ratings); 
		return user;
	}

}
