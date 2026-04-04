package com.klef.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.backend.entity.Webinar;
import com.klef.backend.service.WebinarService;

@RestController
@RequestMapping("/api/webinars")
@CrossOrigin(origins = "http://localhost:5173")
public class WebinarController {

    @Autowired
    private WebinarService webinarService;

    @PostMapping
    public Webinar createWebinar(@RequestBody Webinar webinar) {
        return webinarService.createWebinar(webinar);
    }

    @GetMapping
    public List<Webinar> getAllWebinars() {
        return webinarService.getAllWebinars();
    }

    @GetMapping("/{id}")
    public Optional<Webinar> getWebinarById(@PathVariable Long id) {
        return webinarService.getWebinarById(id);
    }

    @PutMapping("/{id}")
    public Webinar updateWebinar(@PathVariable Long id, @RequestBody Webinar webinar) {
        return webinarService.updateWebinar(id, webinar);
    }

    @DeleteMapping("/{id}")
    public String deleteWebinar(@PathVariable Long id) {
        return webinarService.deleteWebinar(id);
    }
}