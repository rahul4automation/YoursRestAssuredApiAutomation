package airLineAPI;

import extentReport.ExtentReportManager;
import extentReport.LogReport;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.util.Map;

public class AirLineService extends LogReport {

    private static RequestSpecification getRequestSpecification(String endpoint, Object requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }


    public static Response createCustomerAirLines(String endpoint, String requestPayload, Map<String, String> headers) {

        RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);
        Response response =requestSpecification.post();
        loginReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }

    public static Response createPostCustomerAirLines(String endpoint, Map<String, Object> requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);
        Response response =requestSpecification.post();
        loginReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
}
