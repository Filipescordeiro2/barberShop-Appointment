package com.fscordeiro.clientService.service;

import com.fscordeiro.clientService.dto.ClientRegisterResponse;
import com.fscordeiro.clientService.dto.ClientRequest;
import com.fscordeiro.clientService.mapper.ClientMapper;
import com.fscordeiro.clientService.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientRegisterResponse saveClient(ClientRequest request) {
        try {
            log.info("Initialized service [ClientService - saveClient]");

            clientRepository.save(ClientMapper.toClientEntity(request));

            log.info("Finished service [ClientService - saveClient]");
            return ClientMapper.toClientRegisterResponse("Client registered successfully!!");
        }catch (Exception e) {
            throw e;
        }
    }
}
