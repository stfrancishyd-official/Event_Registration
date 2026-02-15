package com.sfc.eventregistration.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sfc.eventregistration.entity.Event;
import com.sfc.eventregistration.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    
    private final EventRepository eventRepository;

    @Override
    public  Event createdEvent(Event event){
        event.setCreatedAt(LocalDateTime.now());
        return eventRepository.save(event);
    }

    @Override

    public  List<Event> getAllEvents(){
        return eventRepository.findAll();
    }
}
