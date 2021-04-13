package com.logicalsapien.covan.analyse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CovanAnalyseApplication.class)
public class CasePredictionIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldFetchCasePredictionWhenPredictionApiCalled() {
        ResponseEntity responseEntity = restTemplate.getForEntity("/analyse/predict?date=2021-04-01&noOfDays=2", Object.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
