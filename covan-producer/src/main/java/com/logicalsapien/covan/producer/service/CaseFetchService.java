package com.logicalsapien.covan.producer.service;

import com.logicalsapien.covan.producer.domain.CaseInfo;
import com.logicalsapien.covan.producer.domain.CaseResponseObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CaseFetchService {

    @Value("${covid.count.gov.api.url}")
    private String covidCountApiUrl;

    private RestTemplate restTemplate;

    public CaseFetchService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CaseInfo> fetchCaseByDate(final LocalDate date) {
        ResponseEntity<CaseResponseObject> response
                = restTemplate.getForEntity(
                        covidCountApiUrl + "?filters=areaType=nation;date=" + date.format(DateTimeFormatter.ofPattern("yyyy-MM-d")) + "&" + getResponseStrucutreParamters(),
                            CaseResponseObject.class);
        return CaseInfo.getCaseInfoListFromResponse(response.getBody());
    }

    private String getResponseStrucutreParamters() {

        StringBuilder structureParameters = new StringBuilder();
        structureParameters.append("structure=");
        structureParameters.append("{");
        structureParameters.append("\"date\":\"date\",");
        structureParameters.append("\"areaName\":\"areaName\",");
        structureParameters.append("\"areaCode\":\"areaCode\",");
        structureParameters.append("\"cases\":\"{");
        structureParameters.append("\"daily\":\"newCasesByPublishDate\",");
        structureParameters.append("\"cumulative\":\"cumCasesByPublishDate\",");
        structureParameters.append("},");
        structureParameters.append("\"deaths\":\"{");
        structureParameters.append("\"daily\":\"newDeathsByDeathDate\",");
        structureParameters.append("\"cumulative\":\"cumDeathsByDeathDate\",");
        structureParameters.append("}");
        structureParameters.append("}");

        return structureParameters.toString();
    }

}
