package airLineAPI;

import common.APIEndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;

public class PassengerServiceApi {

    public static Response createAirLineTicketId(Map<String, Object> jsonRequest, Map<String, String> headers) {
        Response createPassengerResponse = RestAssured.given().contentType(ContentType.JSON).headers(headers).body(jsonRequest).post(APIEndPoints.METHOD_POST_CREATE_PASSENGER).andReturn().then().log().all().extract().response();
        return createPassengerResponse;
    }

    public static Response getPassengerById(Integer passengerId, Map<String, String> headers) {
        return RestAssured.given().contentType(ContentType.JSON).pathParam("id", passengerId).headers(headers).when().get(APIEndPoints.METHOD_GET_PASSENGER).andReturn().then().log().all().extract().response();
    }
}
