package com.klef.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.backend.entity.Webinar;

public interface WebinarRepository extends JpaRepository<Webinar, Long> {
}