package com.sfc.eventregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sfc.eventregistration.entity.Event;

public interface EventRepository extends JpaRepository <Event,Long> {
    
}
