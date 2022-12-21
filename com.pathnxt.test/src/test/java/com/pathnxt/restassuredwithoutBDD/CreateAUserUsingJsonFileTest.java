package com.pathnxt.restassuredwithoutBDD;

import java.io.File;

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
public class CreateAUserUsingJsonFileTest 
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void createauserusingfile()
	{
		//fetching the json file 
		File file = new File(Iconstants.jsonfile);

		//Request
		RequestSpecification req = RestAssured.given();
		req.body(file);
		req.contentType(ContentType.JSON);

		//Action
		Response res = req.post(Iconstants.Baseuri+EndPoints.createproject);

		//Validation
		ValidatableResponse valid = res.then();
		valid.assertThat().contentType(ContentType.JSON);
		valid.assertThat().statusCode(201);
		valid.log().all();
	}
}
