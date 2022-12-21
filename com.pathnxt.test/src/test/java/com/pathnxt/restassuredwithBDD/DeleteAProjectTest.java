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
public class DeleteAProjectTest 
{
	/**
	 * deleting a project using framework
	 */
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void deleteaproject()
	{
		//precondition
		RestAssured.given().contentType(ContentType.JSON)

		//request operation
		.when().delete(Iconstants.Baseuri+EndPoints.deleteproject)

		//validation
		.then().statusCode(204)
		.log().all();
	}
}
