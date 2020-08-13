package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.exception.BusinessException;
import com.banking.model.User;
import com.banking.servcie.RegisterService;

@RestController
public class RegisterController{
	
	@Autowired
	private RegisterService service;
	
	private MultiValueMap<String, String> map;
	@PostMapping("/registration")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}

	@PutMapping("/user")
	public User updateUser(User user) {
		
		return service.updateUser(user);
	}
	
			
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return service.getAllUsers();
	}

	@PutMapping("/admin/{uId}")
	public void enableUser(@PathVariable int uId) {
		
		service.enableUser(uId);
		
				
	}
	
	@PutMapping("/admin/disable/{uId}")
	public void diableUser(@PathVariable int uId) {
		
		service.disableUser(uId);
				
	}
	
	@DeleteMapping("/admin/delete/{uId}")
	public void deleteUserById(@PathVariable("uId")int uId) {

		service.deleteUserById(uId);
	}
//	@Override
//	public void disableUser(int uId) {
//		// TODO Auto-generated method stub
//		
//	}

	
	
}
