package com.pathnxt.commonUtilities;

import io.restassured.response.Response;

public class RestAssuredLibrary
{
public String getjsondata(Response response,String path)
{
	//Storing the json path in a variable
	String jsondata = response.jsonPath().get(path);
	return jsondata;
}
}
