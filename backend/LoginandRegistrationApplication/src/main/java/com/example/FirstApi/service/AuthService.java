package com.example.FirstApi.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.FirstApi.dto.LoginRequest;
import com.example.FirstApi.dto.RegisterRequest;
import com.example.FirstApi.entity.User;
import com.example.FirstApi.repository.UserRepository;


@Service
public class AuthService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	
	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	    this.userRepository = userRepository;
	    this.passwordEncoder = passwordEncoder;
	}
	
	public String register(RegisterRequest request) {
		
		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
		    return "Email already exists!";
		}
		
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		userRepository.save(user);
		return "User registered";

	}

	public String login(LoginRequest request) {
		
		User user = userRepository.findByEmail(request.getEmail()).orElse(null);

		if (user == null) {
		    return "User not found";
		}
		
		if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
		    return "Login successful";
		} else {
		    return "Invalid password";
		}
		
	}
	
}
