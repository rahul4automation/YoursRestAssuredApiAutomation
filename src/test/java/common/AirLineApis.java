package common;

import airLine.Payloads;
import airLineAPI.AirLineService;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AirLineApis {

    public Response createAirLine(Map<String, Object> jsonRequest) {
       String endPoint=(String) Base.dataFromJsonFile.get("CreateAirLineApiEndPoint");
        return AirLineService.createPostCustomerAirLines(endPoint,jsonRequest,new HashMap<>());

    }
}
