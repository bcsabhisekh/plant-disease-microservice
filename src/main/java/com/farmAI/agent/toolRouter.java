package com.farmAI.agent;

import com.farmAI.client.DiseaseClient;
import com.farmAI.client.MandiClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class toolRouter {
    private final MandiClient mandiClient;
    private final DiseaseClient diseaseClient;
    public toolRouter(MandiClient mandiClient, DiseaseClient diseaseClient) {
        this.mandiClient = mandiClient;
        this.diseaseClient = diseaseClient;
    }
    public Mono<String> route(String question) {
        if (question.toLowerCase().contains("mandi price")) {
            return mandiClient.getMandiPrice(question);
        } else if (question.toLowerCase().contains("crop disease")) {
            return diseaseClient.getDiseaseInfo(question);
        } else {
            return Mono.just("Sorry, I don't understand the question.");
        }
    }
}