package com.pathnxt.restassuredvalidation;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
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
public class TimeValidationTest 
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void timevalidation()
	{
		//pre condition
		RequestSpecification req = RestAssured.given().contentType(ContentType.JSON);

		//perform action
		Response res = req.when().get(Iconstants.Baseuri+EndPoints.getallprojects);

		//validation
		ValidatableResponse val = res.then();
		val.assertThat().time(Matchers.lessThan(3550L),TimeUnit.MILLISECONDS);

		//print all the valuse on the consloe
		val.log().all();
	}
}
