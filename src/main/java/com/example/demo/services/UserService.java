package com.example.demo.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.UserProfile;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


	public List<UserProfile> findAll() {
		List<UserProfile> findAll = userRepository.findAll();
		return findAll;
	}
	public void saveUser(UserProfile user, MultipartFile image) throws IOException {
		user.setImgData(image.getBytes());
		user.setType(image.getContentType());
		userRepository.save(user);
		
	}}
