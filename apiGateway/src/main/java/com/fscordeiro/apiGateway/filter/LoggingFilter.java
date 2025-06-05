package com.fscordeiro.apiGateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilter  implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        String clientIp = "unknown";
        if (request.getRemoteAddress() != null && request.getRemoteAddress().getAddress() != null) {
            clientIp = request.getRemoteAddress().getAddress().getHostAddress();
        }

        log.info("[GATEWAY] Requisicao recebida: metodo={}, caminho={}, IP cliente={}",
                request.getMethod(), request.getURI(), clientIp);

        return chain.filter(exchange)
                .doOnSuccess(aVoid -> log.info("[GATEWAY] Requisicao finalizada: metodo={}, caminho={}",
                        request.getMethod(), request.getURI()));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
