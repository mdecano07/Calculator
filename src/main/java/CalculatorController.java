import model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService service;

    @GetMapping("/var/singleTrade")
    public double calculateSingleTradeVar(Request request){
        return service.calculateVar(request);
    }

    @GetMapping("/var/singleTrade")
    public double calculatePortfolioVar(Request request){
//        return service.calculatePortfolioVar(request);
        return 10.0;
    }

}
