package com.berkepite.first.controller;

import com.berkepite.first.security.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping
    public ResponseEntity<String> welcome(@CurrentUser Jwt jwt) {
        return ResponseEntity.ok().body("Welcome to the Todo App! You are authenticated." + jwt.getClaim(""));
    }

    @GetMapping("/home")
    public ResponseEntity<String> home(@CurrentUser Jwt jwt) {
        String ownerId = jwt.getSubject();
        return ResponseEntity.ok().body("You are authenticated! Your owner ID is: " + ownerId + " Navigate to /api/todos to manage your todos.");
    }
}
