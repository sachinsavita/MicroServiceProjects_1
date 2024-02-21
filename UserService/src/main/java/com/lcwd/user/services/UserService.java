package com.lcwd.user.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcwd.user.entities.User;

@Service
public interface UserService {
	
	//create
	User saveUser(User user);
	
	//get all user
	List<User> getAllUser();
	
	//single user
	User getUserById(String id);
	
	//delete
	
	//update

}
