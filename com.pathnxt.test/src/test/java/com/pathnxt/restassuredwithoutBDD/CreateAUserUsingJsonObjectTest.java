package com.pathnxt.restassuredwithoutBDD;

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
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author -Priyaranjan-
 *
 */
@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class CreateAUserUsingJsonObjectTest extends BaseApiClass
{
	@SuppressWarnings("unchecked")
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void createuser() throws EncryptedDocumentException, InvalidFormatException, IOException
	{

		//creating jsonobject for storing the required data
		JSONObject obj = new JSONObject();
		obj.put(excel.readDataFromExcel("restassured", 1, 0), excel.readDataFromExcel("restassured", 1, 1));

		//Request
		RequestSpecification request = RestAssured.given();
		request.body(obj);
		request.contentType(ContentType.JSON);

		//Action
		Response response = request.post(Iconstants.Baseuri+EndPoints.createproject);

		//validation
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();

	}
}
