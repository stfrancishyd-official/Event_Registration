package com.sfc.eventregistration.repository;

import java.util.Optional;
import com.sfc.eventregistration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
