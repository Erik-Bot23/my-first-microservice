package com.erikjarquin.microservice_users.service;

import java.util.List;

import com.erikjarquin.microservice_users.dto.UserRequest;
import com.erikjarquin.microservice_users.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserByld(Long id);
    void deleteUser(Long id);
}
