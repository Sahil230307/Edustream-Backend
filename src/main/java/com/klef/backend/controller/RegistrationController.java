package com.klef.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.backend.entity.Webinar;
import com.klef.backend.service.RegistrationService;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "http://localhost:5173")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/{userId}/{webinarId}")
    public Map<String, String> register(@PathVariable Long userId, @PathVariable Long webinarId) {
        String result = registrationService.registerUserToWebinar(userId, webinarId);

        Map<String, String> response = new HashMap<>();
        response.put("message", result);
        return response;
    }

    @GetMapping("/user/{userId}")
    public List<Webinar> getRegisteredWebinars(@PathVariable Long userId) {
        return registrationService.getRegisteredWebinars(userId);
    }
}