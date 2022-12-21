package com.pathnxt.restassuredwithBDD;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pathnxt.commonUtilities.BaseApiClass;
import com.pathnxt.commonUtilities.EndPoints;
import com.pathnxt.commonUtilities.Iconstants;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class PostUsingJsonObjectTest extends BaseApiClass implements EndPoints
{
	/**
	 * post operaion using jsonobject
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */

	@SuppressWarnings("unchecked")
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void createusinghashmap() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		//store the required data in a json object
		JSONObject js = new JSONObject();
		js.put(excel.readDataFromExcel("restassured", 1, 0), excel.readDataFromExcel("restassured", 1, 1));
		//	js.put(excel.readDataFromExcel("restassured", 2, 0), excel.readDataFromExcel("restassured", 2, 1));
		//	js.put(excel.readDataFromExcel("restassured", 2, 0), excel.readDataFromExcel("restassured", 2, 1));
		//	js.put(excel.readDataFromExcel("restassured", 3, 0), excel.readDataFromExcel("restassured", 3, 1));

		//precondition
		RestAssured.given().body(js).contentType(ContentType.JSON)

		//request operation
		.when().post(Iconstants.Baseuri+EndPoints.createproject)

		//validation
		.then().statusCode(201).contentType(ContentType.JSON)
		.log().all();

	}
}
