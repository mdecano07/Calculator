import com.calculator.CalculatorService;
import com.calculator.model.Request;
import com.calculator.properties.AppProperties;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CalculatorServiceTest {

    private CalculatorService sut = new CalculatorService(createProperties());

    private AppProperties createProperties(){
        var properties = new AppProperties();
        properties.setConfidenceLevel(95);
        return properties;
    }

    @Test
    public void calculateVar(){
        //GIVEN
        var historicalData = new ArrayList<>(Arrays.asList(20.1,15.0,3.5,2.8,4.6,8.2,100.0,7.5,-12.0,60.5,-11.11));
        var request = new Request();
        request.setHistoricData(historicalData);

        //WHEN
        var result = sut.calculateVar(request);

        //THEN
        assertEquals(-12.0,result);
    }

    @Test
    public void createHistoricDataForPortfolio(){
        //GIVEN
        var googleHistoricalData = new ArrayList<>(Arrays.asList(20.1,15.0,3.5,2.8,4.6,8.2,100.0,7.5,12.0,60.5,11.11));
        var facebookHistoricalData = new ArrayList<>(Arrays.asList(27.8,15.7,8.8,5.8,4.9,12.2,100.1,9.5,-17.4,68.5,19.11));

        var historicValues = new  ArrayList<List<Double>>();
        historicValues.add(googleHistoricalData);
        historicValues.add(facebookHistoricalData);

        var request = new Request();
        request.setPortfolioHistoricData(historicValues);

        //WHEN
        var result = sut.calculatePortfolioVar(request);

        //THEN
        assertEquals(2.8,result);
    }
}
