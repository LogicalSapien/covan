package com.logicalsapien.covan.producer.builder;

import com.logicalsapien.covan.producer.domain.CaseInfo;
import com.logicalsapien.covan.producer.domain.CaseResponseObject;
import com.logicalsapien.covan.producer.domain.Count;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CaseResponseObjectBuilder {

    private CaseResponseObject caseResponseObject;

    private List<CaseInfo> caseInfoList;

    public CaseResponseObjectBuilder generateCaseResponseObject() {
        caseResponseObject = new CaseResponseObject();
        caseResponseObject.setData(new ArrayList<>());

        CaseResponseObject.Data caseData1 = new CaseResponseObject.Data();
        caseData1.setDate("2021-04-01");
        caseData1.setAreaName("England");
        Count caseCount1 = new Count();
        caseCount1.setDaily(100);
        caseCount1.setCumulative(1000);
        Count deathCount1 = new Count();
        deathCount1.setDaily(1);
        deathCount1.setCumulative(100);
        caseData1.setCases(caseCount1);
        caseData1.setDeaths(deathCount1);
        caseResponseObject.getData().add(caseData1);

        CaseResponseObject.Data caseData2 = new CaseResponseObject.Data();
        caseData2.setDate("2021-04-01");
        caseData2.setAreaName("Wales");
        Count caseCount2 = new Count();
        caseCount2.setDaily(10);
        caseCount2.setCumulative(100);
        Count deathCount2 = new Count();
        deathCount2.setDaily(1);
        deathCount2.setCumulative(10);
        caseData2.setCases(caseCount2);
        caseData2.setDeaths(deathCount2);
        caseResponseObject.getData().add(caseData2);

        caseInfoList = new ArrayList<>();
        CaseInfo caseInfo1 = new CaseInfo();
        caseInfo1.setCountry("England");
        caseInfo1.setDate(LocalDate.of(2021, 4, 1));
        caseInfo1.setCases(caseCount1);
        caseInfo1.setDeaths(deathCount1);

        CaseInfo caseInfo2 = new CaseInfo();
        caseInfo2.setCountry("Wales");
        caseInfo2.setDate(LocalDate.of(2021, 4, 1));
        caseInfo2.setCases(caseCount2);
        caseInfo2.setDeaths(deathCount2);

        caseInfoList.add(caseInfo1);
        caseInfoList.add(caseInfo2);

        return this;
    }

    public CaseResponseObject getCaseResponseObject() {
        return caseResponseObject;
    }

    public List<CaseInfo> getCaseInfoList() {
        return caseInfoList;
    }
}
