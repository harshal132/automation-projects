package request.types;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.Urls;
import static org.hamcrest.Matchers.*;

public class TestRequest {
  @Test
  public void getRequestTest() {
	  RestAssured.baseURI = Urls.HOSTNAME.getValue();
	  Response response = RestAssured.get(Urls.LIST_USERS.getValue());
	  System.out.println("Status Code: "+response.getStatusCode());
	  System.out.println("Response Time in Milliseconds: "+response.getTimeIn(TimeUnit.MILLISECONDS));
	  System.out.println(response.getBody().asPrettyString());
	  
	  //assertions
	  Assert.assertEquals(response.getStatusCode(), 200);
  }
  
  @Test
  public void getRequestDifferentType() {
	  RestAssured.baseURI = Urls.HOSTNAME.getValue();
	  RestAssured
	  .given()
	  	.get(Urls.LIST_USERS.getValue())
	  .then()
	  	.statusCode(200)
	  	.body("data[1].id", equalTo(8))
	  	.log().all();
  }
}
