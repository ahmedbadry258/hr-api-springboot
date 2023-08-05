package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.*;
import com.example.demo.services.UserService;
@RestController
public class AppController {
	@Autowired
	private UserService userService;
	@RequestMapping("/")
	public String hi() {
		return "Welcome to HR Application"; 
	}
	@GetMapping("users")
	public List<UserProfile> findAllUsers() {
		List<UserProfile> findAll = userService.findAll();
		return findAll; 
	}
	
	@PostMapping(path = "/api/submit-form", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> handleFormSubmission(@RequestParam("user") UserProfile user,
	                                               
	                                               @RequestParam("image") MultipartFile image) throws IOException {
		System.out.println(user.getEmail());
		
		System.out.println(image.getOriginalFilename());
		userService.saveUser(user,image);
	
	    // Process the form data here
	    return ResponseEntity.ok().build();
	}

}
