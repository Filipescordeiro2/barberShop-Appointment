package com.fscordeiro.apiGateway.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.net.ConnectException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
@Order(-2)
public class GlobalExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        if (ex instanceof ConnectException) {

            Map<String, Object> errorResponse = new LinkedHashMap<>();
            errorResponse.put("message", "Conexao recusada: servico indisponivel no momento.");
            errorResponse.put("timestamp", LocalDateTime.now().toString());
            errorResponse.put("api", exchange.getRequest().getPath().value());

            byte[] bytes = toJsonBytes(errorResponse);

            exchange.getResponse().setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);

            log.info("Error: {}",errorResponse);
            return exchange.getResponse().writeWith(Mono.just(exchange.getResponse()
                    .bufferFactory().wrap(bytes)));
        }
        return Mono.error(ex);
    }

    private byte[] toJsonBytes(Map<String, Object> map) {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsBytes(map);
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
