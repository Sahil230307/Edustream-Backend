package com.klef.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.backend.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByUserId(Long userId);
    List<Registration> findByWebinarId(Long webinarId);
    boolean existsByUserIdAndWebinarId(Long userId, Long webinarId);
}