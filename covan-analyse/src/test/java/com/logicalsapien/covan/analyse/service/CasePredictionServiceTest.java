package com.logicalsapien.covan.analyse.service;

import com.logicalsapien.covan.analyse.domain.CasePrediction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CasePredictionServiceTest {

    private CasePredictionService casePredictionService;

    @BeforeEach
    void setUp() {
        this.casePredictionService = new CasePredictionService();
    }

    @Test
    void givenDateAndNumberPredictCasesForNDays() {
        List<CasePrediction> actualPredictionList = casePredictionService.getCasePrediction(LocalDate.now(), 2);
    }

}
