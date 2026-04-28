package com.klef.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.backend.entity.Workshop;
import com.klef.backend.service.WorkshopService;

@RestController
@RequestMapping("/api/workshops")
@CrossOrigin(origins = "http://localhost:5173")
public class WorkshopController {

    @Autowired
    private WorkshopService workshopService;

    @GetMapping
    public List<Workshop> getAll() {
        return workshopService.getAll();
    }

    @GetMapping("/{id}")
    public Workshop getById(@PathVariable Long id) {
        return workshopService.getById(id);
    }

    @PostMapping
    public Workshop create(@RequestBody Workshop workshop) {
        return workshopService.create(workshop);
    }

    @PutMapping("/{id}")
    public Workshop update(@PathVariable Long id, @RequestBody Workshop workshop) {
        return workshopService.update(id, workshop);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        workshopService.delete(id);
    }
}