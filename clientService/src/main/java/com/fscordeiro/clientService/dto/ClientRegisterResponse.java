package com.fscordeiro.clientService.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ClientRegisterResponse(String message, LocalDateTime createdAt) {
}
