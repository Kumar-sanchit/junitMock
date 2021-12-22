package com.junit.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public List<String> getListOfUserLanguages(String user) {
		if(user.equalsIgnoreCase("Shipra")) {
			return List.of("English,Hindi,Bengali");	
		}
		return List.of("English,Gujarati,German");
	}
	
	public String getCountryForUser(String user) {
		if(user.equals("Brian"))
			return new String("Columbia");
		return new String ("Australia");
	}
	
	public boolean isPrimeUser(String user) {
		return checkForPrimeUser(user);
	}
	
	public boolean checkForPrimeUser(String user) {
		List<String> primeUserList = getPrimeUserList();
		return primeUserList.indexOf(user)!=-1 ?  true : false;
	}
	
	public List<String> getPrimeUserList() {
			return new ArrayList<>(Arrays.asList("Joe","Kamala","Trump","Obama","Putin","Modi","Boris"));
	} 
}
