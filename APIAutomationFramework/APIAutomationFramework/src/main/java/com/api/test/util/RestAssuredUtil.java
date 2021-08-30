package com.api.test.util;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredUtil {


    public static Response getResponse(Map<String, String> queryParam, Map<String, String> headers, String url){
        Response response = given().contentType("application/json").
                when().get(url).then().assertThat().statusCode(200).extract().response();
        return response;
    }
}
