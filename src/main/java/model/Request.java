package model;

import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Request {

    private List historicData;

    private double confidenceLevel;

    public Request(List historicData, double confidenceLevel) {
        this.historicData = historicData;
        this.confidenceLevel = confidenceLevel;
    }

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
