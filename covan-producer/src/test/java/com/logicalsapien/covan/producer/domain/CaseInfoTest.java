package com.logicalsapien.covan.producer.domain;

import com.logicalsapien.covan.producer.builder.CaseResponseObjectBuilder;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CaseInfoTest {

    @Test
    void givenEmptyDataReturnNullObject() {
        CaseResponseObject caseResponseObject = new CaseResponseObject();
        caseResponseObject.setData(new ArrayList<>());
        assertThat(CaseInfo.getCaseInfoListFromResponse(caseResponseObject)).isEqualTo(Optional.empty());
    }

    @Test
    void givenStringInputGenerateCaseObject() {

        CaseResponseObjectBuilder builder = new CaseResponseObjectBuilder();

        CaseResponseObject caseResponseObject
                = builder
                    .generateCaseResponseObject()
                    .getCaseResponseObject();

        List<CaseInfo> actualCaseInfoList = CaseInfo.getCaseInfoListFromResponse(caseResponseObject).get();



        assertThat(actualCaseInfoList.size()).isEqualTo(builder.getCaseInfoList().size());
        assertThat(actualCaseInfoList.get(0)).usingRecursiveComparison().isEqualTo(builder.getCaseInfoList().get(0));
    }

}
