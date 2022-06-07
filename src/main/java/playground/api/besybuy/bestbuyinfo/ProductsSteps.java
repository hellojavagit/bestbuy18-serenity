package playground.api.besybuy.bestbuyinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import playground.api.besybuy.constants.EndPoints;
import playground.api.besybuy.model.ProductsPojo;

public class ProductsSteps {

    @Step("Getting All The Products")
    public ValidatableResponse getAllProducts() {
        return SerenityRest.given().log().all()
                .header("Accept", "application/json")
                .when()
                .get(EndPoints.GET_ALL_PRODUCTS)
                .then();
    }





    @Step("Create A  Product With name:{0},type:{1},price:{2},shipping:{3},upc:{4},description:{5},manufacturer:{6},model:{7},url:{8},image:{9})")
    public ValidatableResponse createProduct(String name,String type,int price,int shipping,String upc,
                                             String description,String manufacturer,String model,String url,String image){
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName(name);
        productsPojo.setType(type);
        productsPojo.setPrice(price);
        productsPojo.setShipping(shipping);
        productsPojo.setUpc(upc);
        productsPojo.setDescription(description);
        productsPojo.setManufacturer(manufacturer);
        productsPojo.setModel(model);
        productsPojo.setUrl(url);
        productsPojo.setImage(image);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(productsPojo)
                .when()
                .post(EndPoints.CREATE_PRODUCTS)
                .then();
    }
    @Step("Getting Products By Id")
    public ValidatableResponse getProductsById(long productid) {
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", productid)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCT_BY_ID)
                .then();
    }


    @Step("Update A  Product With name:{0},type:{1},price:{2},shipping:{3},upc:{4},description:{5},manufacturer:{6},model:{7},url:{8},image:{9})")
    public ValidatableResponse updateProduct(long productid,String name,String type,int price,int shipping,String upc,
                                             String description,String manufacturer,String model,String url,String image){
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName(name);
        productsPojo.setType(type);
        productsPojo.setPrice(price);
        productsPojo.setShipping(shipping);
        productsPojo.setUpc(upc);
        productsPojo.setDescription(description);
        productsPojo.setManufacturer(manufacturer);
        productsPojo.setModel(model);
        productsPojo.setUrl(url);
        productsPojo.setImage(image);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(productsPojo)
                .pathParam("id", productid)
                .when()
                .patch(EndPoints.PATCH_PRODUCT_BY_ID)
                .then();
    }


    @Step
    public ValidatableResponse deleteProductById(long productid) {
        return SerenityRest.given().log().all()
                .pathParam("id", productid)
                .when()
                .delete(EndPoints.DELETE_PRODUCT_BY_ID)
                .then();
    }

}
