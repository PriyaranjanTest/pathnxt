package com.pathnxt.restassuredparameter;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author -priyaranjan-
 *
 */
@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class QueryParameterTest 
{

	@Test	(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void queryparameter()
	{
		//pre condition
		RequestSpecification req = RestAssured.given().contentType(ContentType.JSON);

		//setting path parameter
		req.pathParam("path", "users");
		req.queryParam("page", "2");

		//perform operation
		Response res = req.when().get("https://reqres.in/api/{path}");

		//validation
		ValidatableResponse val = res.then();
		val.assertThat().statusCode(200);
		val.assertThat().contentType(ContentType.JSON);

		//print all the value on the console
		val.log().all();
	}
}
