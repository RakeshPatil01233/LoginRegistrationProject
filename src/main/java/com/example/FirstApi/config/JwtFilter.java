package com.example.FirstApi.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                   HttpServletResponse response,
                                   FilterChain filterChain)
            throws ServletException, IOException {

        // 🔹 Step 1: Get Authorization header
        String authHeader = request.getHeader("Authorization");

        // 🔹 Step 2: Check if header has Bearer token
        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7); // remove "Bearer "

            try {
                // 🔹 Step 3: Extract email from token
                String email = jwtUtil.extractUsername(token);

                // 🔹 Step 4: Validate token and set authentication
                if (email != null && !jwtUtil.isTokenExpired(token)
                        && SecurityContextHolder.getContext().getAuthentication() == null) {

                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                    email,
                                    null,
                                    Collections.emptyList()
                            );

                    SecurityContextHolder.getContext().setAuthentication(authToken);

                    System.out.println("✅ Authenticated user: " + email);
                }

            } catch (Exception e) {
                System.out.println("❌ Invalid token");
            }
        }

        // 🔹 Step 5: Continue request (ALWAYS outside try)
        filterChain.doFilter(request, response);
    }
}