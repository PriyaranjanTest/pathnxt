package com.pathnxt.restassuredwithoutBDD;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.EndPoints;
import com.pathnxt.commonUtilities.Iconstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class DeleteAUserTest 
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void deleteauser()
	{
		//precondition
		RequestSpecification req = RestAssured.given();

		//perform action
		Response res = req.when().delete(Iconstants.Baseuri+EndPoints.deleteproject);

		//validation
		ValidatableResponse valid = res.then();
		valid.assertThat().statusCode(204);

		//print on the console
		valid.log().all();
	}
}
