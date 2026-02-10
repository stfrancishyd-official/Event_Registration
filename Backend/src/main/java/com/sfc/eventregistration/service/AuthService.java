package com.sfc.eventregistration.service;

import com.sfc.eventregistration.dto.LoginRequestDto;
import com.sfc.eventregistration.dto.RegisterRequestDto;

public interface AuthService {
    
        String register(RegisterRequestDto request);

        String login(LoginRequestDto request);



}
