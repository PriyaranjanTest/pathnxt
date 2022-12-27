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

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class GetaSingleUserTest 
{
	
	@Test	(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void getasingleuser()
	{
		//precondition
		RequestSpecification req = RestAssured.given();

		//operation/action
		Response response = req.when().get(Iconstants.Baseuri+EndPoints.getsingleproject);

		//validation
		ValidatableResponse valid = response.then();
		valid.assertThat().statusCode(200);
		valid.contentType(ContentType.JSON);

		//print all the info at the console
		valid.log().all();

	}
}
