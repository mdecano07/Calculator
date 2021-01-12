package com.calculator;

import com.calculator.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService service;

    @GetMapping("/var/singleTrade")
    public double calculateSingleTradeVar(List<Double> historicData){
        var request = new Request();
        request.setHistoricData(historicData);
        return service.calculateVar(request);
    }

    @GetMapping("/var/portfolio")
    public double calculatePortfolioVar(List<List<Double>> portfolioData){
        var request = new Request();
        request.setPortfolioHistoricData(portfolioData);
        return service.calculatePortfolioVar(request);
    }

}
