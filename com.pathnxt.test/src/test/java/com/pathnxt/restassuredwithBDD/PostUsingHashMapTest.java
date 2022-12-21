package com.pathnxt.restassuredwithBDD;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.BaseApiClass;
import com.pathnxt.commonUtilities.EndPoints;
import com.pathnxt.commonUtilities.Iconstants;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class PostUsingHashMapTest extends BaseApiClass
{
	@SuppressWarnings("unchecked")
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void createusinghashmap() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		//create a hashmap to store the required data
		HashMap map = new HashMap<>();
		map.put(excel.readDataFromExcel("restassured", 1, 0), excel.readDataFromExcel("restassured", 1, 1));

		//Precondition
		RestAssured.given().body(map).contentType(ContentType.JSON)

		//Request operation
		.when().post(Iconstants.Baseuri+EndPoints.createproject)

		//Response validation
		.then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}
}
