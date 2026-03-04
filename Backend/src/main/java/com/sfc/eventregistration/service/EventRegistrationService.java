package com.sfc.eventregistration.service;


import com.sfc.eventregistration.dto.EventRegistrationDto;
public interface EventRegistrationService {
        String registerStudent(EventRegistrationDto dto);
        // String registerStudent(Long UserId, Long eventId);
}
