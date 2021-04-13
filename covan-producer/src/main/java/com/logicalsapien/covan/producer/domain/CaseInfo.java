package com.logicalsapien.covan.producer.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CaseInfo {

    private String country;

    private LocalDate date;

    private Count cases;

    private Count deaths;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Count getCases() {
        return cases;
    }

    public void setCases(Count cases) {
        this.cases = cases;
    }

    public Count getDeaths() {
        return deaths;
    }

    public void setDeaths(Count deaths) {
        this.deaths = deaths;
    }

    public static Optional<List<CaseInfo>> getCaseInfoListFromResponse(final CaseResponseObject caseString) {
        if (Objects.nonNull(caseString) && Objects.nonNull(caseString.getData()) && !caseString.getData().isEmpty()) {
            List<CaseInfo> caseInfoList = new ArrayList<>();
            for (CaseResponseObject.Data data : caseString.getData()) {
                CaseInfo caseInfo = new CaseInfo();
                caseInfo.setCountry(data.getAreaName());
                caseInfo.setDate(LocalDate.parse(data.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                caseInfo.setCases(data.getCases());
                caseInfo.setDeaths(data.getDeaths());
                caseInfoList.add(caseInfo);
            }
            return Optional.of(caseInfoList);
        } else {
            return Optional.empty();
        }
    }
}
