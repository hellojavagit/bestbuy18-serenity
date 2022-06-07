package playground.api.besybuy.testbase;


import io.restassured.RestAssured;
import org.junit.BeforeClass;
import playground.api.besybuy.utils.PropertyReader;

/**
 * Created by Jay
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));

    }

}
