import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;


public class CalculatorServiceTest {

    private CalculatorService sut;

    @Test
    public void calculateVar(){
        //GIVEN
        var list = new ArrayList<Double>();
        var percentile = 1;

        //WHEN
        var result = sut.calculateVar(list,percentile);

        //THEN
        assertEquals(5.6,result);
    }
}
