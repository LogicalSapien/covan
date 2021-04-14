package com.logicalsapien.covan.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/caseProducerFallBack")
    public String caseProducerFallBack() {
        return "Case producer is acting up. Please try later.";
    }

    @GetMapping("/caseAnalyseFallBack")
    public String caseAnalyseFallBack() {
        return "Case analyse is acting up. Please try later.";
    }

}
