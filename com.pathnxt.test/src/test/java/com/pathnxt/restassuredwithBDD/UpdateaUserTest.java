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
public class UpdateaUserTest extends BaseApiClass
{
	@SuppressWarnings("unchecked")
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void updateuser() throws EncryptedDocumentException, InvalidFormatException, IOException
	{

		//creating json object for storing the required data
		JSONObject js = new JSONObject();
		js.put(excel.readDataFromExcel("restassured", 2, 0), excel.readDataFromExcel("restassured", 2, 1));

		//Precondition
		RestAssured.given().body(js).contentType(ContentType.JSON)

		//request operation
		.when().put(Iconstants.Baseuri+EndPoints.updateproject)

		//Response validation
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
	}
}
