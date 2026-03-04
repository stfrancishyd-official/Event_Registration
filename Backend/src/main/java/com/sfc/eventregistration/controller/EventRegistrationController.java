package com.sfc.eventregistration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfc.eventregistration.service.EventRegistrationService;

import lombok.AllArgsConstructor;

import com.sfc.eventregistration.dto.EventRegistrationDto;

@RestController
@RequestMapping("api/v1/registrations")
@AllArgsConstructor
public class EventRegistrationController {
    
        private final EventRegistrationService eventRegistrationService;

        // public EventRegistrationController(EventRegistrationService eventRegistrationService){
        //     this.eventRegistrationService=eventRegistrationService;
        // }

        @PreAuthorize("hasRole('STUDENT')")
        @PostMapping
        public ResponseEntity<?> register(@RequestBody EventRegistrationDto dto){
            return ResponseEntity.ok(eventRegistrationService.registerStudent(dto));
        }
}
