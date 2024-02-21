package com.lcwd.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.hotel.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
	
	//If you want to implement any custom method or query the here.

}
