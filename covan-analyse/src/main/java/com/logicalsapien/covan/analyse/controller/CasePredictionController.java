package com.logicalsapien.covan.analyse.controller;

import com.logicalsapien.covan.analyse.domain.CasePrediction;
import com.logicalsapien.covan.analyse.service.CasePredictionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/analyse")
public class CasePredictionController {

    @Autowired
    private CasePredictionService casePredictionService;

    @GetMapping("/predict")
    @HystrixCommand(fallbackMethod = "getCasePredictionFallBack")
    public ResponseEntity getCasePrediction(@RequestParam("date") String date, @RequestParam("noOfDays") int noOfDays) {
        List<CasePrediction> casePredictionList
                = casePredictionService.getCasePrediction(
                        LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")), noOfDays);
        return ResponseEntity.ok(casePredictionList);
    }

    private ResponseEntity getCasePredictionFallBack(String date, int noOfDays) {
        return ResponseEntity.status(500).body("Case analyse is acting up. Please try later.");
    }
}
