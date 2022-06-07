package playground.api.besybuy.bestbuyinfo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import playground.api.besybuy.constants.EndPoints;
import playground.api.besybuy.model.StoresPojo;

public class StoresSteps {

    @Step("Getting All Stores")
    public ValidatableResponse getStores() {
        return SerenityRest.given().log().all()
                .header("Accept", "application/json")
                .when()
                .get(EndPoints.GET_ALL_STORES)
                .then();

    }

    @Step("Getting Stores By ID:{0}")
    public ValidatableResponse getStoresById(String storeId) {
        return SerenityRest.given().log().all()
                //.header("Accept", "application/json")
                .pathParam("id", 10)
                .when()
                .get(EndPoints.GET_STORE_BY_ID)
                .then();


    }

    @Step("Creating A New Store  with name :{0}, type :{1}. address :{2}, address2 :{3}, city :{4}, state :{5}, zip:{6}, lat:{7}, lng:{8}, hours:{9}")
    public ValidatableResponse createAStore(String name, String type, String address, String address2, String city, String state,
                                            String zip, float lat, float lng, String hours) {
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);
        storesPojo.setLat(lat);
        storesPojo.setLng(lng);
        storesPojo.setHours(hours);


        return SerenityRest.given()
                //.header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(storesPojo)
                .log().all()
                .when()
                .post(EndPoints.CREATE_STORE)
                .then();

    }

    @Step("Updating Store information with  name :{0}, type :{1}. address :{2}, address2 :{3}, city :{4}")
    public ValidatableResponse updateStoreByID(String storeId,String name, String entertainment, String address, String address2, String city, String state,
                                               String zip, float lat, float lng, String hours) {
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(entertainment);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);
        storesPojo.setLat(lat);
        storesPojo.setLng(lng);
        storesPojo.setHours(hours);

        return SerenityRest.given()
                //.header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .pathParam("id", storeId)
                .when()
                .patch(EndPoints.PATCH_STORE_BY_ID)
                .then();

    }

    @Step("Deleting the Stores With Store id :{0}")
    public ValidatableResponse deleteStoresById(String storeId) {
        return SerenityRest.rest().given()
                .pathParam("id",storeId)
                .when()
                .delete(EndPoints.DELETE_STORE_BY_ID)
                .then();
    }
}


