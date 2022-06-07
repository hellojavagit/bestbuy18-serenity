package playground.api.besybuy.bestbuyinfo;


import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import playground.api.besybuy.testbase.TestBase;
import playground.api.besybuy.utils.TestUtils;

@RunWith(SerenityRunner.class)
public class ServicesCRUDTestWithSteps extends TestBase {
    static String name = "TESTING SERVICE" + TestUtils.getRandomValue();
    static long servicesId;

    @Steps
    ServicesSteps servicesSteps;

    @Title("Getting All The Services")
    @Test
    public void test001(){
        servicesSteps.getServices().log().all().statusCode(200);
    }

    @Title("Creating A New Service")
    @Test
    public void test002(){
        ValidatableResponse response = servicesSteps.createServices(name);
        response.log().all().statusCode(201);

    }
    @Title("Getting The Services By Id")
    @Test
    public void test003(){
        servicesSteps.getServicesById(servicesId).log().all().statusCode(200);
    }

    @Title("Updating The Services By Id")
    @Test
    public void test004(){
        name = name + "_Changed";
        servicesSteps.updateServicesById(name,servicesId).log().all().statusCode(200);
        //HashMap<String, Object> value = servicesSteps.getServices(name);
       // Assert.assertThat(value, hasValue(name));
    }

    @Title("Deleting The Services By Id")
    @Test
    public void test005(){
        servicesSteps.deleteServicesById(servicesId).log().all().statusCode(200);
        servicesSteps.getServicesById(servicesId).statusCode(404).log().all();
    }


}
