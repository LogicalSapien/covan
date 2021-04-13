package com.logicalsapien.covan;

import com.logicalsapien.covan.producer.CovanProducerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CovanProducerApplication.class)
public class CaseFetchIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldFetchCasesWhenFetchApiCalled() {
        ResponseEntity responseEntity = restTemplate.getForEntity("/cases/fetch?date=2021-04-01", Object.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
