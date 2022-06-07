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
public class StoresCRUDTestWithSteps extends TestBase {

    static String name = "abcd"+ TestUtils.getRandomValue();
    static String type = "entertainment";
    static String address = "Dudley Road";
    static String address2 = "Landudno";
    static String city = "Cardiff";
    static String state = "Wales";
    static String zip = "1453788";
    static float lat = 120;
    static float lng = 140;
    static String hours= "10.00am";

    String storeId;

    @Steps
    StoresSteps storesSteps;

    @Title("Getting All The Store")
    @Test
    public void test001(){
        storesSteps.getStores().log().all().statusCode(200);

    }

    @Title("Creating  The Store")
    @Test
    public void test002(){
        ValidatableResponse response = storesSteps.createAStore(name,type, address, address2, city, state, zip, lat, lng, hours);
        response.log().all().statusCode(201);

    }

    @Title("GettingThe Store By ID")
    @Test
    public void test003(){
        storesSteps.getStoresById(storeId).log().all().statusCode(200);

    }

    @Title("Updating The Store By Id")
    @Test
    public void test004(){
        name = name+"_UPDATED";
        storesSteps.updateStoreByID(storeId,name,type, address, address2, city, state, zip, lat, lng, hours).log().all().statusCode(200);

    }

    @Title("Deleting The Store")
    @Test
    public void test005(){
        storesSteps.deleteStoresById(storeId).statusCode(200);
        storesSteps.getStoresById(storeId).statusCode(404);
    }

    }

