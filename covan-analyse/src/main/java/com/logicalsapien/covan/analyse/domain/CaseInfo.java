package com.logicalsapien.covan.analyse.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

}
