package model;

import java.util.List;

public class Request {

    private double confidenceLevel;
    private List historicData;

    public double getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(double confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }

    public List getHistoricData() {
        return historicData;
    }

    public void setHistoricData(List historicData) {
        this.historicData = historicData;
    }
}
