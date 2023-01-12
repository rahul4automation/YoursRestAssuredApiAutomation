package airLine;

import airLineAPI.AirLineService;
import common.APIEndPoints;
import common.JsonUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AirLineTests {

    @Test
    public void createAirLine() {
        Response response = AirLineService.createCustomerAirLines(APIEndPoints.METHOD_POST_CREATE_AIRLINES,
                Payloads.postCreateAirLinePayload("111299", "Sri Lankan Airways", "Sri Lanka", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                        "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "19999"), new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void createAirLineUsingMap() {
        Response response = AirLineService.createPostCustomerAirLines(APIEndPoints.METHOD_POST_CREATE_AIRLINES, Payloads.postCreateAirLineUsingMap("9822", "Sri Lankan Airways", "Sri Lanka", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "19977"), new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void createAirLineUsingData() throws IOException {

        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        Map <String, String> data= JsonUtils.getJsonDataAsMap("airLines/qa/airLinesApiData.json");
        String endPoint=data.get("CreateAirLineApiEndPoint");
        Response response = AirLineService.createPostCustomerAirLines(endPoint, Payloads.postCreateAirLineUsingMap("98892", "Sri Lankan Airways", "Sri Lanka", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990"), new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
