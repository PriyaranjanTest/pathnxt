package com.pathnxt.commonUtilities;
/**
 * 
 * @author -Priyaranjan-
 *
 */
public interface EndPoints 
{
	//Endpoints for CRUD operation
	String createproject="/api/users";
	String updateproject="/api/users/2";
	String getallprojects="/api/users?page=2";
	String getsingleproject="/api/users/2";
	String deleteproject="/api/users/2";
	String login="/api/login";
	
}
