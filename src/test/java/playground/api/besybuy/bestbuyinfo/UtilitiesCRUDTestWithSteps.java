package playground.api.besybuy.bestbuyinfo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UtilitiesCRUDTestWithSteps {

    @Steps
    UtilitiesSteps utilitiesSteps;

    @Title("Getting the Version")
    @Test
    public void test001(){
        utilitiesSteps.getVersion().log().all().statusCode(200);
    }
    @Title("Getting the HealthCheck")
    @Test
    public void test002(){
        utilitiesSteps.getHealthCheck().log().all().statusCode(200);
    }
}
