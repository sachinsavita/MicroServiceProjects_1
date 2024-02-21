package com.lcwd.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.entities.User;
import com.lcwd.user.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create 
	@PostMapping("/")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		User rUser = userService.saveUser(user);
		//return new ResponseEntity<>(HttpStatus.CREATED);
		return ResponseEntity.status(HttpStatus.CREATED).body(rUser);
	}
	
	@GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Spring Boot");
        return "hello";
    }
	
	//single user get
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId)
	{
		User user = userService.getUserById(userId);
		return new ResponseEntity<>(user ,HttpStatus.OK);
	}
	
	//all user get
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> users = userService.getAllUser();
		return ResponseEntity.ok(users);
	}
	
	

}
