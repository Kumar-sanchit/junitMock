package com.junit.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.junit.example.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class TU_UserController {

	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	@BeforeEach
	void init_mocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetLanguagesForUser() {
		 List<String> languages = new ArrayList<>();
		 languages.add("English");
		 languages.add("Hindi");
		 languages.add("Bengali");
		 Mockito.when(userService.getListOfUserLanguages("Shipra"))
		 .thenReturn(languages);
		 List<String> userLanguages = userService.getListOfUserLanguages("Shipra");
		 Assert.assertTrue(userLanguages.size() == languages.size());
		 Assert.assertEquals(userLanguages.get(0), languages.get(0));
		 Assert.assertEquals(userLanguages.get(1), languages.get(1));
		 Assert.assertEquals(userLanguages.get(2), languages.get(2));
	}
	
	@Test
	public void testIsPrimeUser() {
		Mockito.when(userService.isPrimeUser("Joe")).thenReturn(true);
		Assert.assertEquals(userService.isPrimeUser("Joe"), true);
	}
	
	@Test
	public void testGetPrimeUserList() {
		List<String> list = List.of("Kamala", "Joe");
		Mockito.when(userService.getPrimeUserList()).thenReturn(list);
		List<String> userList = userService.getPrimeUserList();
		Assert.assertEquals(list.size(), userList.size());
		Assert.assertEquals(list.get(0),userList.get(0));
		Assert.assertEquals(list.get(1),userList.get(1));
	}
	
	@Test
	public void testCheckForPrimeUser() {
		Mockito.when(userService.checkForPrimeUser("Joe")).thenReturn(true);
		Assert.assertEquals(userService.checkForPrimeUser("Joe"),true);
	}
	
	@Test
	public void testCheckForPrimeUserNegative() {
		Mockito.when(userService.checkForPrimeUser("Rcb")).thenReturn(false);
		Assert.assertEquals(userService.checkForPrimeUser("Rcb"),false);
	}
	
	@Test
	public void testGetCountryForUser() {
		String country = "Columbia";
		Mockito.when(userService.getCountryForUser("Brian")).thenReturn(country);
		String countryName = userService.getCountryForUser("Brian");
		Assert.assertTrue(country.equalsIgnoreCase(countryName));
	}
	
}
