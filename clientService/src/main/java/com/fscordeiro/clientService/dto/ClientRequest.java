package com.fscordeiro.clientService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Builder
public record ClientRequest(
        @CPF(message = "cpf is invalid")
        @NotBlank(message = "cpf is required")
        String cpf,
        @NotBlank(message = "name is required")
        String name,
        @NotBlank(message = "surName is required")
        String surName,
        @NotBlank(message = "phone is required")
        String phone,
        @Email(message = "email is invalid")
        @NotBlank(message = "email is required")
        String email,
        @NotBlank(message = "sex is required")
        String sex,
        @NotNull(message = "birthDate is required")
        LocalDate birthDate
) {
}
