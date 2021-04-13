package com.logicalsapien.covan.producer.service;

import com.logicalsapien.covan.producer.domain.CaseInfo;
import com.logicalsapien.covan.producer.domain.CaseResponseObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class CaseFetchService {

    @Value("${covid.count.gov.api.url}")
    private String covidCountApiUrl;

    private RestTemplate restTemplate;

    public CaseFetchService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<List<CaseInfo>> fetchCaseByDate(final LocalDate date) {
        String jsonView = getResponseStrucutreParamters();
        String url = covidCountApiUrl + "?filters=areaType=nation;date=" + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "&structure={jsonView}";

        ResponseEntity<CaseResponseObject> response = restTemplate.getForEntity(url, CaseResponseObject.class, jsonView);
        return CaseInfo.getCaseInfoListFromResponse(response.getBody());
    }

    private String getResponseStrucutreParamters() {

        StringBuilder structureParameters = new StringBuilder();
        structureParameters.append("{");
        structureParameters.append("\"date\":\"date\",");
        structureParameters.append("\"areaName\":\"areaName\",");
        structureParameters.append("\"areaCode\":\"areaCode\",");
        structureParameters.append("\"cases\":{");
        structureParameters.append("\"daily\":\"newCasesByPublishDate\",");
        structureParameters.append("\"cumulative\":\"cumCasesByPublishDate\"");
        structureParameters.append("},");
        structureParameters.append("\"deaths\":{");
        structureParameters.append("\"daily\":\"newDeathsByDeathDate\",");
        structureParameters.append("\"cumulative\":\"cumDeathsByDeathDate\"");
        structureParameters.append("}");
        structureParameters.append("}");

        return structureParameters.toString();
    }

}
