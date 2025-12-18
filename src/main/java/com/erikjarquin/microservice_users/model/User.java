package com.erikjarquin.microservice_users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Entity
@Table(name="users")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Se usa para generar un id unico
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable=false, length = 100) //Se crea el campo para el nombre
    private String name;
    @Column(nullable = false, unique=true, length = 150) //Se crea la columba para un email único
    private String email;
}
