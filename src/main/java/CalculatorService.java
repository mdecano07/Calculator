import model.Request;

import java.util.Collections;
import java.util.List;

public class CalculatorService {

    public double calculateVar(List<Double> values, double percentile) {
        Collections.sort(values);
        var index = (int) Math.ceil((percentile / 100) * values.size());
        return values.get(index - 1);
    }

    public double calculatePortfolioVar(Request req){
        return 10;
    }

}
