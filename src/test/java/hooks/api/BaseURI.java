package hooks.api;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import utilities.ConfigReader;

public class BaseURI {

    @BeforeAll
    public void setupApi(){

        RestAssured.baseURI = ConfigReader.getProperty("baseUrl");

    }
}
