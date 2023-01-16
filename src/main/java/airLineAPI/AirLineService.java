package airLineAPI;

import extentReport.ExtentReportManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.util.Map;

public class AirLineService {

    private static RequestSpecification getRequestSpecification(String endpoint, Object requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    private static void loginReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("EndPoint is : " +queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Methods is : " +queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are : " +queryableRequestSpecification.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Request body is : " +queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("Response status is : "  +response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response header are : " +response.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Response body  is : " +response.getStatusCode());

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
