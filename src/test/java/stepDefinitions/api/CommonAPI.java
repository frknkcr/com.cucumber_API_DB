package stepDefinitions.api;

import hooks.api.HooksAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.Authentication;
import utilities.ConfigReader;

public class CommonAPI {

    Response response;


    @Then("{string} endpoint'ine gecerli authorization bilgileri ile bir GET request gönderilir")
    public void endpoint_ine_gecerli_authorization_bilgileri_ile_bir_get_request_gönderilir(String path) {

        response = RestAssured.given().contentType(ContentType.JSON).when()
                .headers("Authorization",Authentication.getToken()).get(path);


        response.prettyPrint();

        response.then().assertThat().statusCode(200);


    }
    @When("dönen status code'un {int} oldugu ve response message bilgisinin {string} oldugu dogrulanmali")
    public void dönen_status_code_un_oldugu_ve_response_message_bilgisinin_oldugu_dogrulanmali(Integer int1, String string) {


        JsonPath path = response.jsonPath();

        Assert.assertEquals(string,path.getString("message"));
        Assert.assertEquals(int1,path.get("status"));



    }

    @Given("API user sets {string} path parameters")
    public void apiUserSetsPathParameters(String rawPaths) {

        JSONObject reqbodys= new JSONObject();
        reqbodys.put("id",3);
        response = RestAssured.given().contentType(ContentType.JSON).when()
                .headers("Authorization",Authentication.getToken()).body(reqbodys.toString()).get(rawPaths);
        response.prettyPrint();
    }

    @And("Verifies that the status code returned when GET request is sent is {int} and the response message information is {string}")
    public void verifiesThatTheStatusCodeReturnedWhenGETRequestIsSentIsAndTheResponseMessageInformationIs(int basariliStatus, String message) {
        JsonPath path=response.jsonPath();
        Assert.assertEquals(basariliStatus,response.statusCode());
        Assert.assertEquals(message,path.getString("message"));

    }
}


