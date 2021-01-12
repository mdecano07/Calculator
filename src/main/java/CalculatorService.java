import model.Request;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CalculatorService {

    //calculates var using historical values for a single trade
    public double calculateVar(Request request) {
        //List<Double> values, double percentile
        List historicalValues = request.getHistoricData();
        Collections.sort(historicalValues);
        var index = (int) Math.ceil((1-(request.getConfidenceLevel() / 100)) * historicalValues.size());
        return (double) historicalValues.get(index - 1);
    }

    //calculates var for multiple trades, with multiple historical values
    public double calculatePortfolioVar(List<List<Double>> historicalValues, double confidenceLevel){
        var historicData = getPortfolioHistoricData(historicalValues);
        var request = new Request(historicData,confidenceLevel);
        return calculateVar(request);
    }

    //calculates the sum of historical value
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
