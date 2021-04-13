package com.logicalsapien.covan.producer.controller;

import com.logicalsapien.covan.producer.domain.CaseInfo;
import com.logicalsapien.covan.producer.service.CaseFetchService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cases")
public class CaseController {

    private CaseFetchService caseFetchService;

    public CaseController(final CaseFetchService caseFetchService) {
        this.caseFetchService = caseFetchService;
    }

    @GetMapping("/fetch")
    public ResponseEntity getCasesByDate(@RequestParam("date") String date) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException ex) {
            return ResponseEntity.badRequest().body("Invalid date format");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Invalid date filter");
        }

        Optional<List<CaseInfo>> caseInfoListOptional = caseFetchService.fetchCaseByDate(localDate);
        if (caseInfoListOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(caseInfoListOptional.get());
    }
}
