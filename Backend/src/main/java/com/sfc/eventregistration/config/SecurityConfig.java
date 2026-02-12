package com.sfc.eventregistration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    
      @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())  // 🔥 disable CSRF completely for now

            .authorizeHttpRequests(auth -> auth
                // .requestMatchers("/api/v1/auth/**").permitAll()
                // .anyRequest().authenticated()
                 .anyRequest().permitAll()   // Allow all requests
            )

            .httpBasic(basic -> basic.disable())
            .formLogin(form -> form.disable());

        return http.build();
    }

        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

}
