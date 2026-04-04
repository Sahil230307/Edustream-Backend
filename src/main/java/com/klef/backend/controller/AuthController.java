package com.klef.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.backend.entity.User;
import com.klef.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {
        String result = userService.register(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", result);
        return response;
    }

    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        User loggedInUser = userService.login(user.getEmail(), user.getPassword());

        if (loggedInUser != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("id", loggedInUser.getId());
            response.put("name", loggedInUser.getName());
            response.put("email", loggedInUser.getEmail());
            response.put("role", loggedInUser.getRole());
            return response;
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Invalid email or password");
            return response;
        }
    }
}