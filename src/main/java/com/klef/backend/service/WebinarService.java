package com.klef.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.backend.entity.Webinar;
import com.klef.backend.repository.WebinarRepository;

@Service
public class WebinarService {

    @Autowired
    private WebinarRepository webinarRepository;

    public Webinar createWebinar(Webinar webinar) {
        return webinarRepository.save(webinar);
    }

    public List<Webinar> getAllWebinars() {
        return webinarRepository.findAll();
    }

    public Optional<Webinar> getWebinarById(Long id) {
        return webinarRepository.findById(id);
    }

    public Webinar updateWebinar(Long id, Webinar updated) {
        Optional<Webinar> optional = webinarRepository.findById(id);

        if (optional.isPresent()) {
            Webinar webinar = optional.get();
            webinar.setTitle(updated.getTitle());
            webinar.setDescription(updated.getDescription());
            webinar.setSpeaker(updated.getSpeaker());
            webinar.setDate(updated.getDate());
            webinar.setTime(updated.getTime());
            webinar.setMeetingLink(updated.getMeetingLink());
            webinar.setImageUrl(updated.getImageUrl());
            webinar.setRecordingUrl(updated.getRecordingUrl());
            webinar.setMaterials(updated.getMaterials());

            return webinarRepository.save(webinar);
        }

        return null;
    }

    public String deleteWebinar(Long id) {
        if (webinarRepository.existsById(id)) {
            webinarRepository.deleteById(id);
            return "Webinar deleted successfully";
        }
        return "Webinar not found";
    }
}