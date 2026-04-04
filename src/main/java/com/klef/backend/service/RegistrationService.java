package com.klef.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.backend.entity.Registration;
import com.klef.backend.entity.Webinar;
import com.klef.backend.repository.RegistrationRepository;
import com.klef.backend.repository.WebinarRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private WebinarRepository webinarRepository;

    public String registerUserToWebinar(Long userId, Long webinarId) {
        boolean alreadyExists = registrationRepository.existsByUserIdAndWebinarId(userId, webinarId);

        if (alreadyExists) {
            return "User already registered for this webinar";
        }

        Registration registration = new Registration();
        registration.setUserId(userId);
        registration.setWebinarId(webinarId);

        registrationRepository.save(registration);
        return "Registration successful";
    }

    public List<Webinar> getRegisteredWebinars(Long userId) {
        List<Registration> registrations = registrationRepository.findByUserId(userId);
        List<Webinar> webinars = new ArrayList<>();

        for (Registration reg : registrations) {
            Optional<Webinar> webinar = webinarRepository.findById(reg.getWebinarId());
            webinar.ifPresent(webinars::add);
        }

        return webinars;
    }
}