package com.sfc.eventregistration.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sfc.eventregistration.dto.LoginRequestDto;
import com.sfc.eventregistration.dto.RegisterRequestDto;
import com.sfc.eventregistration.entity.Role;
import com.sfc.eventregistration.entity.User;
import com.sfc.eventregistration.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {


            private final UserRepository userRepository;
            private final PasswordEncoder passwordEncoder;

            public AuthServiceImpl(UserRepository userRepository , PasswordEncoder passwordEncoder){
                this.userRepository=userRepository;
                this.passwordEncoder=passwordEncoder;
            }

            @Override
            public String register(RegisterRequestDto request){

                    if(userRepository.existsByEmail(request.getEmail())){
                        return "Email Already Registered";
                    }

                    User user =new User();
                    user.setEmail(request.getEmail());
                    user.setPassword(passwordEncoder.encode(request.getPassword()));
                    user.setRole(Role.valueOf(request.getRole()));

                    //Student fields

                    user.setRollNumber(request.getRollNumber());
                    user.setSection(request.getSection());
                    user.setYear(request.getYear());

                    // faculty fields

                    user.setFacultyName(request.getFacultyName());

                    userRepository.save(user);

                    return "User Registered Succesfully";

            }

            @Override
            public String login(LoginRequestDto request){
                
                    User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(()-> new RuntimeException("User not found"));

                    if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
                        throw new RuntimeException("Invalid Password");
                    }
                    return "Login successful";

            }
}
