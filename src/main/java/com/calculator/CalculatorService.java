package com.calculator;

import com.calculator.model.Request;
import com.calculator.properties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CalculatorService {

    private AppProperties appProperties;

    @Autowired
    public CalculatorService(AppProperties appProperties){
        this.appProperties = appProperties;
    }

    //calculates var using historical values for a single trade
    public double calculateVar(Request request) {
        List historicalValues = request.getHistoricData();
        Collections.sort(historicalValues);
        var index = (int) Math.ceil((1-(appProperties.getConfidenceLevel() / 100)) * historicalValues.size());
        return (double) historicalValues.get(index - 1);
    }

    //calculates var for multiple trades, with multiple historical values
    public double calculatePortfolioVar(Request request){
        var historicData = getPortfolioHistoricData(request.getPortfolioHistoricData());
        var varRequest = new Request();
        varRequest.setHistoricData(historicData);
        return calculateVar(varRequest);
    }

    //calculates the sum of historical value given
     private List<Double> getPortfolioHistoricData(List<List<Double>> historicalValues) {
        var portfolioHistoricData = new ArrayList<Double>();

        historicalValues.forEach(historicalValue -> {
            for (int i = 0; i < historicalValue.size(); i++) {
                if (historicalValue.size() > portfolioHistoricData.size()){
                    portfolioHistoricData.add(i,historicalValue.get(i));
                } else {
                    var value = historicalValue.get(i) + portfolioHistoricData.get(i);
                    portfolioHistoricData.add(i,value);
                }
            }
        });
        return portfolioHistoricData;
    }

}
