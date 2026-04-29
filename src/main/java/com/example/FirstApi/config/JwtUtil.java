package com.example.FirstApi.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;


import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
	
	
	private final String SECRET = "mysecretkeymysecretkeymysecretkey"; 
	
	public String generateToken(String email) {

	    return Jwts.builder()
	            .setSubject(email)
	            .setIssuedAt(new Date())
	            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
	            .signWith(getSignKey(), SignatureAlgorithm.HS256)
	            .compact();
	}
	
	private Key getSignKey() {
	    return Keys.hmacShaKeyFor(SECRET.getBytes());
	}
	
	public String extractUsername(String token) {
	    return extractAllClaims(token).getSubject();
	}
	
	private Claims extractAllClaims(String token) {
	    return Jwts.parserBuilder()
	            .setSigningKey(getSignKey())
	            .build()
	            .parseClaimsJws(token)
	            .getBody();
	}
	
	
	public boolean isTokenValid(String token, String email) {
	    final String extractedEmail = extractUsername(token);
	    return (extractedEmail.equals(email) && !isTokenExpired(token));
	}
	
	public boolean isTokenExpired(String token) {
	    return extractAllClaims(token).getExpiration().before(new Date());
	}

}