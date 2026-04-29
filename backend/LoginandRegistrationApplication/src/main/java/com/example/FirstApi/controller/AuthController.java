package com.example.FirstApi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstApi.dto.LoginRequest;
import com.example.FirstApi.dto.RegisterRequest;
import com.example.FirstApi.service.AuthService;





@RestController
@RequestMapping("/auth")


public class AuthController {
	
	 private AuthService authService;

	    public AuthController(AuthService authService) {
	        this.authService = authService;
	    }
	        
	        @PostMapping("/register")
	        public String register(@RequestBody RegisterRequest request) {
	            return authService.register(request);
	        }
	        
	        @PostMapping("/login")
	        public String login(@RequestBody LoginRequest request) {
	            return authService.login(request);
	        }
	        
	        
}
