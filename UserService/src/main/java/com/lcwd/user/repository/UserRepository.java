package com.lcwd.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	//If you want to implement any custom method or query the here.

}
