package com.daniel.jobportal.repository;

import com.daniel.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);   // Spring Data JPA will create the appropriate query automatically. That's magic =)))
}
