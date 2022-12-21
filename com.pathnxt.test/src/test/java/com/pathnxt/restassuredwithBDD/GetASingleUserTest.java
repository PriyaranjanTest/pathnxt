package com.pathnxt.restassuredwithBDD;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.pathnxt.commonUtilities.EndPoints;
import com.pathnxt.commonUtilities.Iconstants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * 
 * @author -priyaranjan-
 *
 */
@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class GetASingleUserTest 
{
	/**
	 * fetch a user details
	 */
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void getauser()
	{
		//presondition
		RestAssured.given().contentType(ContentType.JSON)

		//request operation
		.when().get(Iconstants.Baseuri+EndPoints.getsingleproject)

		//validation
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
	}
}
