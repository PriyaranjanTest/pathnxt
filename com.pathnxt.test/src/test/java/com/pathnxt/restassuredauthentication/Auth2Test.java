package com.pathnxt.restassuredauthentication;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
/**
 * 
 * @author -Priyaranjan-
 *
 */

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class Auth2Test 
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void auth2()
	{
		//pre condition
		RequestSpecification req = RestAssured.given().auth().oauth2(null).contentType(ContentType.JSON);

		//perform operation
		Response res = req.when().post();

		//validation
		ValidatableResponse val = res.then();
		val.assertThat().statusCode(201);
		val.assertThat().contentType(ContentType.JSON);

		//print all the value on the console
		val.log().all();
	}
}
