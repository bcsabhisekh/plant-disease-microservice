package com.farmAI.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MandiClient {
    private final WebClient webClient;
    public MandiClient(WebClient webClient) {
        this.webClient = webClient;
    }
    public Mono<List<MandiResponse>> getPrices(String state, String commodity) {
        return webClient.get()
                .uri("http://localhost:8080/api/mandi/prices?state={state}&commodity={commodity}",
                        state, commodity)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
}