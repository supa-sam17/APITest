package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.utils;


public class StepDefenition extends utils {
	RequestSpecification res;
	ResponseSpecification responspec;
	Response response;
	TestDataBuild data = new TestDataBuild(); 

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
    // Write code here that turns the phrase above into concrete actions
	
		
	responspec =  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
	
	res = given().spec(requestSpecification())
	.body(data.addPlacePayload(name, language, address));
	
    //throw new io.cucumber.java.PendingException();
}

@When("user calls {string} with Post http request")
public void user_calls_with_post_http_request(String string) {
    // Write code here that turns the phrase above into concrete actions
	response = res.when().post("/maps/api/place/add/json")
			.then().spec(responspec).extract().response();
   
}

@Then("the API call got success with status code {int}")
public void the_api_call_got_success_with_status_code(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
	assertEquals(response.getStatusCode(),200);
	
}

@And("{string} in response body is {string}")
public void in_response_body_is(String keyValue, String expectedvalue) {
    // Write code here that turns the phrase above into concrete actions
	String resp = response.asString();
	//System.out.println(resp);
	JsonPath js = new JsonPath(resp);
	assertEquals(js.get(keyValue),expectedvalue);
	   
}


	
}
