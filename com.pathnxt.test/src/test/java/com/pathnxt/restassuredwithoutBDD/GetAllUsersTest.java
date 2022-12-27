package com.pathnxt.restassuredwithoutBDD;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.EndPoints;
import com.pathnxt.commonUtilities.Iconstants;

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
public class GetAllUsersTest 
{
	
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void getallusers()
	{
		//pre conditions
		RequestSpecification req = RestAssured.given();

		//perform the action
		Response response = req.when().get(Iconstants.Baseuri+EndPoints.getallprojects);

		//validation
		ValidatableResponse val = response.then();
		val.assertThat().statusCode(200);
		val.contentType(ContentType.JSON);

		//print on console
		val.log().all();
	}
}
