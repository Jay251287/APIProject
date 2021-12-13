package com.rmgyantra.genericLib;

import io.restassured.response.Response;

public class JSONUtility {
	
	public String jsonPathFinder(String jsonpath, Response response)
	{
		String text = response.jsonPath().get(jsonpath);
		return text;
	}
}
