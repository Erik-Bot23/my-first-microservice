package com.erikjarquin.microservice_users.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.erikjarquin.microservice_users.dto.UserRequest;
import com.erikjarquin.microservice_users.dto.UserResponse;
import com.erikjarquin.microservice_users.exception.EmailAlreadyUsedException;
import com.erikjarquin.microservice_users.exception.UserNotFoundException;
import com.erikjarquin.microservice_users.model.User;
import com.erikjarquin.microservice_users.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = new User(null, request.getName(), request.getEmail());
        user = userRepository.save(user);
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> new UserResponse(u.getId(), u.getName(), u.getEmail()))
                .toList();
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserResponse updateUser(Long id, UserRequest request){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        if (request.getEmail() != null && !request.getEmail().equals(user.getEmail())) {
            boolean emailEnUso = userRepository.existsByEmail(request.getEmail());
            if (emailEnUso) {
                throw new EmailAlreadyUsedException(request.getEmail());
            }
        }

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user = userRepository.save(user);
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

}
