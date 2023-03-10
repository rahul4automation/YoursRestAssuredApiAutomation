package airLineAPI;

import common.APIEndPoints;
import extentReport.LogReport;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AirLineApis extends AirLineService {

    public Response createAirLine(Map<String, Object> jsonRequest) {
        String endPoint = (String) Base.dataFromJsonFile.get("CreateAirLineApiEndPoint");
        return AirLineService.createPostCustomerAirLines(endPoint, jsonRequest, new HashMap<>());

    }

    public static Response createAirLineTicketId(Map<String, Object> jsonRequest, Map<String, String> headers) {
        Response createAirLineResponse = RestAssured.given().contentType(ContentType.JSON).headers(headers).body(jsonRequest).post(APIEndPoints.METHOD_POST_CREATE_AIRLINES).andReturn();
        printResponseLogInReport(createAirLineResponse);
        return createAirLineResponse;
    }

    public static Response getAirLineById(Integer ticketId, Map<String, String> headers) {
        Response response = RestAssured.given().contentType(ContentType.JSON).pathParam("id", ticketId).headers(headers).when().get(APIEndPoints.METHOD_GET_AIRLINES).andReturn().then().log().all().extract().response();
        printResponseLogInReport(response);
        return response;
    }
}
