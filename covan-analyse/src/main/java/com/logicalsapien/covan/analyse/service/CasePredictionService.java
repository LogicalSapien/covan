package com.logicalsapien.covan.analyse.service;

import com.logicalsapien.covan.analyse.domain.CasePrediction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CasePredictionService {

    public List<CasePrediction> getCasePrediction(final LocalDate date, final int noOfDays) {
        return new ArrayList<>();
    }
}
