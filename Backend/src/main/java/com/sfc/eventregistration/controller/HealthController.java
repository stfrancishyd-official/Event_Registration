package com.sfc.eventregistration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1")
public class HealthController {
    
    @GetMapping("/health")
    public String health(){
        return "Event registartion API is running";
    }
    
}
