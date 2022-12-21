package com.pathnxt.restassuredwithBDD;

import java.io.File;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.BaseApiClass;
import com.pathnxt.commonUtilities.EndPoints;
import com.pathnxt.commonUtilities.Iconstants;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * 
 * @author -Priyaranjan-
 *
 */
@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class PostUsingJsonFileTest extends BaseApiClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void createusingjsonfile()
	{
		//creating object of file to fetch the json file
		File file=new File(Iconstants.jsonfile);

		//Precondition
		RestAssured.given().body(file).contentType(ContentType.JSON)

		//Request operation
		.when().post(Iconstants.Baseuri+EndPoints.createproject)

		//Response validation
		.then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}
}
