package com.sfc.eventregistration.service;

import java.util.List;

import com.sfc.eventregistration.entity.Event;

public interface EventService {
    Event createdEvent(Event event);
    List<Event> getAllEvents();
}
