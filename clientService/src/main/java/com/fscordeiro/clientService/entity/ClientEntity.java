package com.fscordeiro.clientService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb-client")
public class ClientEntity {

    @Id
    private String cpf;

    private String name;
    private String surName;
    private String phone;
    private String email;
    private String sex;
    private Integer age;
    private LocalDate birthDate;

    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    private void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        age = Period.between(birthDate, LocalDate.now()).getYears();
        active = true;
    }

    @PreUpdate
    private void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
