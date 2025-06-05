package com.fscordeiro.clientService.repository;

import com.fscordeiro.clientService.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, String> {
}
