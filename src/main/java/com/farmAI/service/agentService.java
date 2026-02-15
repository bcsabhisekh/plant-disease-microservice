package com.farmAI.service;

import com.farmAI.agent.toolRouter;
import com.farmAI.controller.FarmerRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class agentService{
    private final ToolRouter toolRouter;

    public agentService(ToolRouter toolRouter) {
        this.toolRouter = toolRouter;
    }

    public Mono<String> handleRequest(FarmerRequest request) {
        return toolRouter.route(request.getQuestion());
    }
}
