package com.fscordeiro.clientService.controller;

import com.fscordeiro.clientService.dto.ClientRegisterResponse;
import com.fscordeiro.clientService.dto.ClientRequest;
import com.fscordeiro.clientService.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientRegisterResponse saveClient(@Valid @RequestBody ClientRequest request){
        return service.saveClient(request);
    }
}
