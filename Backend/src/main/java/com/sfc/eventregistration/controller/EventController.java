package com.sfc.eventregistration.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfc.eventregistration.entity.Event;
import com.sfc.eventregistration.service.EventService;

@RestController
@RequestMapping("/api/v1/events")

public class EventController {
            
    private final EventService eventService;

    public EventController(EventService eventService){
          this.eventService=eventService;
    }

    // faculty creates events
    @PostMapping
      public Event createEvent(@RequestBody Event event){
                return eventService.createdEvent(event);
      }

      // Student View events
      @GetMapping
      public List<Event> getAllEvents(){
        return eventService.getAllEvents();
      }

}
