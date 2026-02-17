package com.sfc.eventregistration.service;

import java.time.LocalDateTime;

import com.sfc.eventregistration.entity.Event;
import com.sfc.eventregistration.entity.EventRegistration;
import com.sfc.eventregistration.entity.User;
import com.sfc.eventregistration.repository.EventRegistrationRepository;
import com.sfc.eventregistration.repository.EventRepository;
import com.sfc.eventregistration.repository.UserRepository;

public class EventRegistrationServiceImpl implements EventRegistrationService{

        private final EventRegistrationRepository registrationRepository;
        private final UserRepository userRepository;
        private final EventRepository eventRepository;

        public EventRegistrationServiceImpl(EventRegistrationRepository registrationRepository ,
             UserRepository userRepository ,
            EventRepository eventRepository
        ){
            this.registrationRepository=registrationRepository;
            this.userRepository=userRepository;
            this.eventRepository=eventRepository;
        }

        @Override
       public  String registerStudent(Long userId, Long eventId){
        if(registrationRepository.findByUserIdAndEventId(userId, eventId)
        .isPresent()){
            return "Student already registred for this event";
        }

                User user =userRepository.findById(userId)
                            .orElseThrow(()-> 
                            new RuntimeException("User not Found"));

                Event event =eventRepository.findById(eventId)
                             .orElseThrow(() ->
                            new RuntimeException("Event not found"));

                EventRegistration registration = new EventRegistration();
                                  registration.setUser(user);
                                  registration.setEvent(event);
                                  registration.setRegistrationDate(LocalDateTime.now());

                registrationRepository.save(registration);
                return "Event Registration Sucessfull";
       }
}
