package com.fscordeiro.clientService.service;

import com.fscordeiro.clientService.dto.ClientRegisterResponse;
import com.fscordeiro.clientService.dto.ClientRequest;
import com.fscordeiro.clientService.entity.ClientEntity;
import com.fscordeiro.clientService.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientRegisterResponse saveClient(ClientRequest request) {
        try {
            log.info("Initialized service [ClientService - saveClient]");

            var client=ClientEntity
                    .builder()
                    .cpf(request.cpf())
                    .name(request.name())
                    .surName(request.surName())
                    .phone(request.phone())
                    .email(request.email())
                    .sex(request.sex())
                    .birthDate(request.birthDate())
                    .build();

            clientRepository.save(client);
            log.info("Finished service [ClientService - saveClient]");
            return ClientRegisterResponse
                    .builder()
                    .message("Client registered successfully")
                    .createdAt(LocalDateTime.now())
                    .build();
        }catch (Exception e) {
            throw e;
        }
    }
}
