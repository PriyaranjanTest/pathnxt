package com.pathnxt.restassuredwithoutBDD;

import java.io.File;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.BaseApiClass;
import com.pathnxt.commonUtilities.EndPoints;
import com.pathnxt.commonUtilities.Iconstants;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class UpdateUserTest extends BaseApiClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void upodateuser()
	{
		//fetching the json file
		File file=new File(Iconstants.jsonfile);

		//precondition
		RequestSpecification req = RestAssured.given();
		req.body(file);
		req.contentType(ContentType.JSON);

		//perform action
		Response response = req.when().put(Iconstants.Baseuri+EndPoints.updateproject);

		//validation
		ValidatableResponse val = response.then();
		val.assertThat().statusCode(200);
		val.contentType(ContentType.JSON);

		//print on the console
		val.log().all();

	}
}
