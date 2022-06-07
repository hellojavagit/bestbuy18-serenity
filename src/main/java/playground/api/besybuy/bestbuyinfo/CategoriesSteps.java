package playground.api.besybuy.bestbuyinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import playground.api.besybuy.constants.EndPoints;
import playground.api.besybuy.model.CategoriesPojoTest;

public class CategoriesSteps {

    @Step("Getting All Categories")
    public ValidatableResponse getCategories() {
        return SerenityRest.rest().given()
                .header("Accept", "application/json")
                .when()
                .get(EndPoints.GET_ALL_CATEGORIES)
                .then();
    }

    @Step("Getting Categories With Category Id :{1}")
    public ValidatableResponse getCategoriesById(String categoriesId) {
        return SerenityRest.rest().given()
                .header("Accept", "application/json")
                .pathParam("id", categoriesId)
                .when()
                .get(EndPoints.GET_CATEGORIES_BY_ID)
                .then();
    }

    @Step("Creating Categories with name : {0} , id : {1}")
    public ValidatableResponse createNewCategories(String name, String id) {
        CategoriesPojoTest categoriesPojo = new CategoriesPojoTest();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        return SerenityRest.rest().given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post(EndPoints.CREATE_CATEGORIES)
                .then();

    }

    @Step("Updating Categories With name:{0},id:{1}")
    public ValidatableResponse updateCategoriesById(String name, String id) {
        CategoriesPojoTest categoriesPojo = new CategoriesPojoTest();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        return SerenityRest.rest().given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .patch(EndPoints.UPDATE_CATEGORIES_BY_ID)
                .then();
    }

    @Step("Deleting Categories By Id:{0}")
    public ValidatableResponse deleteCategoriesById(String categoriesId) {
        return SerenityRest.rest().given()
                .pathParam("id", categoriesId)
                .when()
                .delete(EndPoints.DELETE_CATEGORIES_BY_ID)
                .then();

    }


}
