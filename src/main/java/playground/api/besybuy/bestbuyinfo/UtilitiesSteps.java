package playground.api.besybuy.bestbuyinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.runner.RunWith;
import playground.api.besybuy.constants.EndPoints;


@RunWith(SerenityRunner.class)
public class UtilitiesSteps {


    @Step("Getting Version")
    public ValidatableResponse getVersion() {
        return SerenityRest.given().log().all()
                .header("Accept", "application/json")
                .when()
                .get(EndPoints.GET_VERSION)
                .then();
    }


        @Step("Getting HealthCheck ")
    public ValidatableResponse getHealthCheck() {
        return SerenityRest.given().log().all()
                .header("Accept", "application/json")
                .when()
                .get(EndPoints.GET_HEALTHCHECK)
                .then();

    }



}
