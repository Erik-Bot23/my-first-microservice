package com.erikjarquin.microservice_users.repository;

import com.erikjarquin.microservice_users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByEmail(String email);
}
