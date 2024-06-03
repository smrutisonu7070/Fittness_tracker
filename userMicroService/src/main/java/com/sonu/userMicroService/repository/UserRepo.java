package com.sonu.userMicroService.repository;

import com.sonu.userMicroService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {

    Optional<User> findByEmail(String userEmail);
}
