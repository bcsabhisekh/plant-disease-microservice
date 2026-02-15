package com.farmAI.controller;

import com.farmAI.service.agentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
// import com.farmAI.controller.dto.FarmerRequest;

@RestController
@RequestMapping("/api/farmer")
public class FarmerController{
    private final agentService agent;
    public FarmerController( agentService agent){
        this.agent =agent;
    }

    @PostMapping("/ask")
    public Mono<String> ask(@RequestBody FarmerRequest request){
        return agent.handleRequest(request);
    }


}
