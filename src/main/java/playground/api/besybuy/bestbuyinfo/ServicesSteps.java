package playground.api.besybuy.bestbuyinfo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import playground.api.besybuy.constants.EndPoints;
import playground.api.besybuy.model.ServicesPojoTest;

public class ServicesSteps {

    @Step("Getting All Services")
    public ValidatableResponse getServices() {
        return SerenityRest.given().log().all()
                .header("Accept", "application/json")
                .when()
                .get(EndPoints.GET_ALL_SERVICES)
                .then();
    }

    @Step("Getting Services By ID:{0}")
    public ValidatableResponse getServicesById(long servicesId) {
        return SerenityRest.given().log().all()
                //.header("Accept", "application/json")
                .pathParam("id", servicesId)
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_SERVICES_BY_ID)
                .then();
    }

    @Step("Creating services with name : {0} ")
    public ValidatableResponse createServices(String name) {

        ServicesPojoTest servicesPojo = new ServicesPojoTest();
        servicesPojo.setName(name);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post(EndPoints.CREATE_SERVICES)
                .then();
    }

    @Step("Getting the services information with servicesId : {0}")

    public ValidatableResponse updateServicesById(String name, long servicesId) {

        ServicesPojoTest servicesPojo = new ServicesPojoTest();
        servicesPojo.setName(name);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .patch(EndPoints.UPDATE_SERVICES_BY_ID)
                .then();
    }


    @Step("Deleting the Services information with ServicesId : {0} ")
    public ValidatableResponse deleteServicesById(long servicesId) {

        return SerenityRest.rest().given().log().all()
                .pathParam("id", servicesId)
                .when()
                .delete(EndPoints.DELETE_SERVICES_BY_ID)
                .then();

    }
}
