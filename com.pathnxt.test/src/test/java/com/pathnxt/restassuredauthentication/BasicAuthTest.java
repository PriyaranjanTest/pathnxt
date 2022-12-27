package com.pathnxt.restassuredauthentication;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BasicAuthTest 
{
	public void basicauth()
	{
		//pre condition
		RequestSpecification req = RestAssured.given().auth().basic(null, null);

		//perform action
		Response res = req.when().post();

		//validation
		ValidatableResponse val = res.then();
		val.assertThat().statusCode(201);
		val.assertThat().contentType(ContentType.JSON);

		//print all at the console
		val.log().all();
	}
}
