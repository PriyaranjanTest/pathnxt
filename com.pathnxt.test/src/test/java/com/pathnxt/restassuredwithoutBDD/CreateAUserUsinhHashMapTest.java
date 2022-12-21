package com.pathnxt.restassuredwithoutBDD;

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
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@Listeners(com.pathnxt.commonUtilities.listenersImplementation.class)
public class CreateAUserUsinhHashMapTest extends BaseApiClass
{
	@Test(retryAnalyzer = com.pathnxt.commonUtilities.RetryAnalyzerImptn.class)
	public void creteuserusinghashmap() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		//creatin a hashmap for storing the required data
		HashMap<Object, Object> map = new HashMap<>();
		map.put(excel.readDataFromExcel("restassured", 1, 0), excel.readDataFromExcel("restassured", 1, 1));
		map.put(excel.readDataFromExcel("restassured", 2, 0), excel.readDataFromExcel("restassured", 2, 1));

		//request
		RequestSpecification req = RestAssured.given();
		req.body(map);
		req.contentType(ContentType.JSON);

		//action
		Response res = req.post(Iconstants.Baseuri+EndPoints.createproject);

		//validation
		ValidatableResponse valid = res.then();
		valid.assertThat().contentType(ContentType.JSON);
		valid.assertThat().statusCode(201);
		valid.log().all();
	}
}
