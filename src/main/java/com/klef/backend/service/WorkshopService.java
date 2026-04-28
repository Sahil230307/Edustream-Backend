package com.klef.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.backend.entity.Workshop;
import com.klef.backend.repository.WorkshopRepository;

@Service
public class WorkshopService {

    @Autowired
    private WorkshopRepository workshopRepository;

    public List<Workshop> getAll() {
        return workshopRepository.findAll();
    }

    public Workshop getById(Long id) {
        return workshopRepository.findById(id).orElse(null);
    }

    public Workshop create(Workshop workshop) {
        return workshopRepository.save(workshop);
    }

    public Workshop update(Long id, Workshop updated) {
        Workshop w = workshopRepository.findById(id).orElse(null);
        if (w == null) return null;

        w.setTitle(updated.getTitle());
        w.setSpeaker(updated.getSpeaker());
        w.setDate(updated.getDate());
        w.setTime(updated.getTime());
        w.setDescription(updated.getDescription());
        w.setImageUrl(updated.getImageUrl());

        return workshopRepository.save(w);
    }

    public void delete(Long id) {
        workshopRepository.deleteById(id);
    }
}