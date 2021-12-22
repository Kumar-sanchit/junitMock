package com.junit.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.junit.example.service.UserService;

@RestController
public class UserController {
	
	public UserService getUserService() {
		return userService;
	}

	@Autowired
	private UserService userService;
	
	@GetMapping("/welcome")
	public String getWelcomeMessage(){
		return "hello";
	}	
	
	@GetMapping("/getLanguagesForUser/{user}/user") 
	public List<String> getLanguagesForUser(@PathVariable String user) {
		return userService.getListOfUserLanguages(user);
	}
	
	@GetMapping("/getUserCountryForUser/{user}/user")
	public String getCountryForUser(@PathVariable String user) {
		return userService.getCountryForUser(user);
	}
	
	@GetMapping("/isPrimeUser/{user}/prime")
	public boolean getIsPrimeUser(@PathVariable String user) {
		return userService.isPrimeUser(user);
	}
}
