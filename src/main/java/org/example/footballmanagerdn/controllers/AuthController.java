package org.example.footballmanagerdn.controllers;

import org.example.footballmanagerdn.models.User;
import org.example.footballmanagerdn.security.JwtResponse;
import org.example.footballmanagerdn.security.JwtTokenProvider;
import org.example.footballmanagerdn.security.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtService;

    @Autowired
    private SecurityUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication
                = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByEmail(user.getEmail());
        return ResponseEntity.ok(
                new JwtResponse(
                        currentUser.getId(),
                        jwt, "Bearer",
                        userDetails.getUsername(),
                        userDetails.getUsername(),
                        userDetails.getAuthorities()
                )
        );
    }
}