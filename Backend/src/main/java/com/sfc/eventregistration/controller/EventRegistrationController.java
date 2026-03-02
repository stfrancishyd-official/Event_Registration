package com.sfc.eventregistration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sfc.eventregistration.service.EventRegistrationService;
import com.sfc.eventregistration.dto.EventRegistrationDto;

@RestController
@RequestMapping("api/v1/registrations")
public class EventRegistrationController {
    
        private final EventRegistrationService registrationService;

        public EventRegistrationController(EventRegistrationService registrationService){
            this.registrationService=registrationService;
        }

        @PreAuthorize("hasRole('STUDENT')")
        @PostMapping
        public ResponseEntity<?> register(@RequestBody EventRegistrationDto dto){
            return ResponseEntity.ok(EventRegistrationService.registerStudent(dto));
        }
}
