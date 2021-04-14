package com.logicalsapien.covan.analyse.service;

import com.logicalsapien.covan.analyse.domain.CaseInfo;
import com.logicalsapien.covan.analyse.domain.CasePrediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CasePredictionService {

    @Autowired
    private RestTemplate restTemplate;

    public List<CasePrediction> getCasePrediction(final LocalDate date, final int noOfDays) {

        CaseInfo[] caseInfoArray = restTemplate.getForEntity(
                        "http://COVAN-PRODUCER/cases/fetch?date=" + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                CaseInfo[].class).getBody();

        List<CasePrediction> casePredictionList = new ArrayList<>();
        for (CaseInfo caseInfo : caseInfoArray) {
            CasePrediction casePrediction = new CasePrediction();
            casePrediction.setCountry(caseInfo.getCountry());
            casePrediction.setCases(caseInfo.getCases().getDaily() - (long)(caseInfo.getCases().getDaily() * 0.1));
            casePrediction.setDeaths(caseInfo.getDeaths().getDaily() - (long)(caseInfo.getDeaths().getDaily() * 0.1));
            casePredictionList.add(casePrediction);
        }

        return casePredictionList;
    }
}
