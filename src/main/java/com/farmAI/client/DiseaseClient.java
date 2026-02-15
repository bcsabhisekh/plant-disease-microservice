package com.farmAI.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DiseaseClient {
    private final WebClient webclient;
    public DiseaseClient(WebClient webclient) {
        this.webclient = webclient;
    }
    public Mono<String> getDiseaseInfo(String question) {
        String crop = extractCropFromQuestion(question);
        return webclient.get()
                .uri("http://localhost:8080/api/disease/info?crop={crop}", crop)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
}
