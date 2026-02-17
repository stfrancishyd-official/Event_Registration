package com.sfc.eventregistration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sfc.eventregistration.entity.EventRegistration;

public interface EventRegistrationRepository extends JpaRepository<EventRegistration,Long> {
    
    Optional<EventRegistration> findByUserIdAndEventId(Long userId , Long eventId);
}
