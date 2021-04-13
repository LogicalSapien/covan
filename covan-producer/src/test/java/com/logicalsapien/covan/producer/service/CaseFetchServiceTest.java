package com.logicalsapien.covan.producer.service;

import com.logicalsapien.covan.producer.builder.CaseResponseObjectBuilder;
import com.logicalsapien.covan.producer.domain.CaseInfo;
import com.logicalsapien.covan.producer.domain.CaseResponseObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CaseFetchServiceTest {

    private CaseFetchService caseFetchService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        this.caseFetchService = new CaseFetchService(restTemplate);
    }

    @Test
    void givenDateFetchCaseForDate() {
        CaseResponseObjectBuilder builder = new CaseResponseObjectBuilder();

        CaseResponseObject caseResponseObject
                = builder
                .generateCaseResponseObject()
                .getCaseResponseObject();

        when(restTemplate.getForEntity(anyString(), any(), anyString())).thenReturn(ResponseEntity.ok(caseResponseObject));
        List<CaseInfo> caseInfoFetched
                = this.caseFetchService.fetchCaseByDate(
                        LocalDate.parse("2020-04-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"))).get();
        assertThat(caseInfoFetched).usingRecursiveComparison().isEqualTo(builder.getCaseInfoList());
    }

}
