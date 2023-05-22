package hooks.api;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import utilities.ConfigReader;

public class BaseURI {

    @Before
    public void setupApi(){

        RestAssured.baseURI = ConfigReader.getProperty("nasaBaseUrl");

    }

}
