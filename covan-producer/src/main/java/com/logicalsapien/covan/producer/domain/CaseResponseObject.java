package com.logicalsapien.covan.producer.domain;

import java.util.List;

public class CaseResponseObject {

    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {

        private String date;
        private String areaName;
        private Count cases;
        private Count deaths;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
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

}
