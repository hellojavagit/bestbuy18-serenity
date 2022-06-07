package playground.api.besybuy.bestbuyinfo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import playground.api.besybuy.testbase.TestBase;
import playground.api.besybuy.utils.TestUtils;

@RunWith(SerenityRunner.class)
public class ProductCURDTest extends TestBase {

    static String name = "phone" + TestUtils.getRandomValue();
    static String type = "mobile";
   static int price = 2000;
   static int shipping = 1000;
    static String upc = "098766543213";
    static String description = "Branded Latest Mobile Phone";
   static String manufacturer = "APPLE";
   static String model = "XPRO";
   static String url = "http://www.apple.com/mobiles";
   static String image = "image1.png";

    static long productid;

    @Steps
    ProductsSteps productsSteps;


    @Title("Getting All The Products")
    @Test
    public void test001() {
        productsSteps.getAllProducts().statusCode(200);
    }

    @Title("Getting The Products By Id")
    @Test
    public void test002() {
        productsSteps.getProductsById(productid).statusCode(200);
    }

    @Title("Create Product")
    @Test
    public void test003() {
      productid =  productsSteps.createProduct(name,type,price,shipping,upc,description,manufacturer,model,url,image).statusCode(201).log().all().extract().response()
                .body().jsonPath().getLong("id");
        System.out.println("product id is "+productid);
        productsSteps.getProductsById(productid).statusCode(200).log().all();

    }

    @Title("Verify if Product is updated")
    @Test
    public void test004(){
        name = "Type Of "+ name;
        manufacturer = manufacturer+"13 model";
        productsSteps.updateProduct(productid,name,type,price,shipping,upc,description,manufacturer,model,url,image).log().all().statusCode(200);
       // productsSteps.getProductsById(prodid).body("name", equalTo(name));

    }
    @Title("This will delete and verify if product is deleted")
    @Test
    public void test005() {

        productsSteps.deleteProductById(productid).log().all().statusCode(200);
        productsSteps.getProductsById(productid).log().all().statusCode(404);
    }




}
