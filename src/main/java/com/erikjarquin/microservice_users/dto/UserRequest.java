package com.erikjarquin.microservice_users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class UserRequest {
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
}
