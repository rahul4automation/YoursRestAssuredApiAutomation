package airLineAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class AirLineService {
    public static Response createCustomerAirLines(String endpoint, String requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post().
                then().log().all().extract().response();
    }

    public static Response createPostCustomerAirLines(String endpoint, Map<String,Object> requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post().
                then().log().all().extract().response();
    }
}
