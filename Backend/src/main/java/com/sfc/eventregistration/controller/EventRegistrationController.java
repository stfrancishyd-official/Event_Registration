package com.sfc.eventregistration.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sfc.eventregistration.service.EventRegistrationService;

@RestController
@RequestMapping("api/v1/registrations")
public class EventRegistrationController {
    
        private final EventRegistrationService registrationService;

        public EventRegistrationController(EventRegistrationService registrationService){
            this.registrationService=registrationService;
        }

        @PostMapping
        public String register(@RequestParam Long userId, @RequestParam Long eventId){
            return registrationService.registerStudent(userId, eventId);
        }
}
