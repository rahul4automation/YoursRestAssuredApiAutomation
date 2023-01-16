package extentReport;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class LogReport {
    private static void loginReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("EndPoint is : " +queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Methods is : " +queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are : " +queryableRequestSpecification.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Request body is : " +queryableRequestSpecification.getBody());
    }

    public static void printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("Response status is : "  +response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response header are : " +response.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Response body  is : " +response.getStatusCode());

    }
}
