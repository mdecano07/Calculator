package com.calculator.model;

import java.util.List;

public class Request {

    private List<Double> historicData;

    private List<List<Double>> portfolioHistoricData;

    public List<Double> getHistoricData() {
        return historicData;
    }

    public void setHistoricData(List<Double> historicData) {
        this.historicData = historicData;
    }

    public List<List<Double>> getPortfolioHistoricData() {
        return portfolioHistoricData;
    }

    public void setPortfolioHistoricData(List<List<Double>> portfolioHistoricData) {
        this.portfolioHistoricData = portfolioHistoricData;
    }
}
