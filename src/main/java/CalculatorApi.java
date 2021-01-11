import model.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorApi {

    private CalculatorService service;

    @GetMapping("/var/singleTrade")
    public double calculateSingleTradeVar(Request request){
        return service.calculateVar(request.getHistoricData(),request.getConfidenceLevel());
    }

    @GetMapping("/var/singleTrade")
    public double calculatePortfolioVar(Request request){
        return service.calculatePortfolioVar(request);
    }

}
