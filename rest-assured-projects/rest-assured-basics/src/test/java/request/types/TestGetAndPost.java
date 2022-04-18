package request.types;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.Urls;

public class TestGetAndPost {
	@Test
	public void testGetRequest() {
		RestAssured.baseURI = Urls.HOSTNAME.getValue();
		Response response = RestAssured.
			when()
				.get(Urls.SINGLE_USER.getValue())
			.then()
				.statusCode(200)
				.extract()
				.response();
		System.out.println("Response Received: \n"+response.asPrettyString());
		System.out.println("First Name found = "+ response.jsonPath().getString("data.first_name"));
	}
}
