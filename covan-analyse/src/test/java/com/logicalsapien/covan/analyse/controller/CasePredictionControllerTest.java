package com.logicalsapien.covan.analyse.controller;


import com.logicalsapien.covan.analyse.service.CasePredictionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CasePredictionControllerTest {

    private CasePredictionController casePredictionController;

    @Mock
    private CasePredictionService casePredictionService;

    @BeforeEach
    void setUp() {
        casePredictionController = new CasePredictionController();
    }

    @Test
    void givenDateAndNumberReturnPrediction() {
        ResponseEntity responseEntity = casePredictionController.getCasePrediction("2021-04-01", 2);
    }

}
