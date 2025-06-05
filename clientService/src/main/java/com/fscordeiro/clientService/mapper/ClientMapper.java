package com.fscordeiro.clientService.mapper;

import com.fscordeiro.clientService.dto.ClientRegisterResponse;
import com.fscordeiro.clientService.dto.ClientRequest;
import com.fscordeiro.clientService.entity.ClientEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClientMapper {

    public static ClientEntity toClientEntity(ClientRequest request) {
        return ClientEntity
                .builder()
                .cpf(request.cpf())
                .name(request.name())
                .surName(request.surName())
                .phone(request.phone())
                .email(request.email())
                .sex(request.sex())
                .birthDate(request.birthDate())
                .build();
    }

    public static ClientRegisterResponse toClientRegisterResponse(String message) {
        return ClientRegisterResponse
                .builder()
                .message(message)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
