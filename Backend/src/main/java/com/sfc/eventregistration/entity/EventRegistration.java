package com.sfc.eventregistration.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="event_registrations",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "event_id"})
    }
)
@Setter
@Getter
public class EventRegistration {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        //Many registration belong to one student
        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;

        // Many registrations belong to one event
        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private Event event;

        private LocalDateTime registrationDate;

        // Getter @ Setter

}
