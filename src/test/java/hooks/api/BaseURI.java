package hooks.api;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import org.junit.Before;
import utilities.Authentication;
import utilities.ConfigReader;

public class BaseURI {

    @BeforeAll
    public static void setupApi(){

        RestAssured.baseURI = ConfigReader.getProperty("baseUrl");

    }
}
