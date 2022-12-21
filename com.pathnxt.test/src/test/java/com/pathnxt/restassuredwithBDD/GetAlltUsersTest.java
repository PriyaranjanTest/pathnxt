package com.pathnxt.restassuredwithBDD;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.pathnxt.commonUtilities.EndPoints;
import com.pathnxt.commonUtilities.Iconstants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
/**
 * @author -priyaranjan-
 */
@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class GetAlltUsersTest 
{
	/**
	 * fetch all the users details
	 */

	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void getallusers()
	{
		//Precondition
		RestAssured.given().contentType(ContentType.JSON)

		//Request operation
		.when().get(Iconstants.Baseuri+EndPoints.getallprojects)

		//Response validation
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
	}
}
