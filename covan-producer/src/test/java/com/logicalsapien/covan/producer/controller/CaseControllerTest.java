package com.logicalsapien.covan.producer.controller;

import com.logicalsapien.covan.producer.builder.CaseResponseObjectBuilder;
import com.logicalsapien.covan.producer.domain.CaseInfo;
import com.logicalsapien.covan.producer.service.CaseFetchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CaseControllerTest {

    private CaseController caseController;

    @Mock
    private CaseFetchService caseFetchService;

    @BeforeEach
    void setUp() {
        caseController = new CaseController(caseFetchService);
    }

    @Test
    void givenValidDateParameterShouldReturnCaseList() {
        List<CaseInfo> caseInfoList
                = new CaseResponseObjectBuilder().generateCaseResponseObject().getCaseInfoList();
        when(caseFetchService.fetchCaseByDate(any())).thenReturn(Optional.of(caseInfoList));
        ResponseEntity responseEntity = caseController.getCasesByDate("2021-04-01");
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(caseInfoList);
    }

    @Test
    void givenNoDateParameterShouldReturnErrorResponse() {
        ResponseEntity responseEntity = caseController.getCasesByDate(null);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(responseEntity.getBody()).isEqualTo("Invalid date filter");
    }

    @Test
    void givenInvalidDateParameterShouldReturnErrorResponse() {
        ResponseEntity responseEntity = caseController.getCasesByDate("202104-01");
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(responseEntity.getBody()).isEqualTo("Invalid date format");
    }

    @Test
    void givenNoResponseFromServiceShouldReturnNotFoundError() {
        ResponseEntity responseEntity = caseController.getCasesByDate("2021-04-01");
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

}
