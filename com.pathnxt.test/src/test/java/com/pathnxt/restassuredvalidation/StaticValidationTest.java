package com.pathnxt.restassuredvalidation;

import org.testng.Assert;
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
public class StaticValidationTest 
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void staticvalidation()
	{
		//storing actual data in a variable
		String actdata="Tobias";

		//pre condition
		RequestSpecification req = RestAssured.given().contentType(ContentType.JSON);

		//perform action
		Response res = req.when().get(Iconstants.Baseuri+EndPoints.getallprojects);

		//get the required data using json path
		String expdata=res.jsonPath().get("data[2].first_name");

		//validation
		ValidatableResponse val = res.then();
		Assert.assertEquals(actdata, expdata);
		System.out.println("actual data matches expected data");

		//printing all on the console
		val.log().all();

	}
}
