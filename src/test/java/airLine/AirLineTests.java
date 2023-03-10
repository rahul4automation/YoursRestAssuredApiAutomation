package airLine;

import airLineAPI.AirLineApis;
import airLineAPI.AirLineService;
import common.APIEndPoints;
import common.JsonUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Step;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class AirLineTests extends AirLineApis {

    private static final Random random = new Random();

    @Test(priority = 1)
    public void createAirLine() {
        Response response = AirLineService.createCustomerAirLines(APIEndPoints.METHOD_POST_CREATE_AIRLINES,
                Payloads.postCreateAirLinePayload(String.valueOf(random.nextInt()), "Sri Lankan Airways", "Sri Lanka", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                        "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990"), new HashMap<>());
        validateCreateAirLineTicket(Integer.parseInt(String.valueOf(response.getStatusCode())), 200);
    }

    @Test(priority = 2)
    public void createAirLineUsingMap() {
        Response response = AirLineService.createPostCustomerAirLines(APIEndPoints.METHOD_POST_CREATE_AIRLINES, Payloads.postCreateAirLineUsingMap(String.valueOf(random.nextInt()), "Sri Lankan Airways", "Sri Lanka", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1991"), new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 3)
    public void createAirLineUsingData() throws IOException {
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        Map<String, String> data = JsonUtils.getJsonDataAsMap("airLines/qa/airLinesApiData.json");
        String endPoint = data.get("CreateAirLineApiEndPoint");
        Response response = AirLineService.createPostCustomerAirLines(endPoint, Payloads.postCreateAirLineUsingMap(String.valueOf(random.nextInt()), "Sri Lankan Airways", "Sri Lanka", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1992"), new HashMap<>());
        validateCreateAirLineTicket(Integer.parseInt(String.valueOf(response.getStatusCode())), 200);
    }

    @Test(priority = 4)
    public void createPostAirLineId() {
        Map<String, Object> createAirLinePayload = Payloads.postCreateAirLineUsingMap(String.valueOf(random.nextInt()), "Sri Lankan Airways", "Sri Lanka", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1992");
        Response response = createAirLine(createAirLinePayload);
        validateCreateAirLineTicket(Integer.parseInt(String.valueOf(response.getStatusCode())), 200);
    }

    @Step("Validate Status of Post Create Airline id ")
    private void validateCreateAirLineTicket(int actualStatus, int expectedStatus) {
        assertEquals(actualStatus, expectedStatus);
    }
}

