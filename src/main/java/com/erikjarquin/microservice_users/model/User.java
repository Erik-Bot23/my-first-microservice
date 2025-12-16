package com.erikjarquin.microservice_users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Se usa para generar un id unico
    private Long id;
    @Column(nullable=false) //Se crea el campo para el nombre
    private String name;
    @Column(nullable = false, unique=true) //Se crea la columba para un email único
    private String email;
}
