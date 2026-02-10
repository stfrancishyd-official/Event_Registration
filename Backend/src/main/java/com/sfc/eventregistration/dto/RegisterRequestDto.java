package com.sfc.eventregistration.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDto {
    
        private String email;
        private String password;

        // Student fields
            private String rollNumber;
            private String section;
            private Integer year;

            // faculty fields
                private String facultyName;

                private String role; // STUDENT/ADMIN/SUPER_ADMIN
                // getters & setters


}
