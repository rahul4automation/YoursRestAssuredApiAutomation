package airLine;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    /* To pass request body payload using string */
    public static String postCreateAirLinePayload(String id, String name, String Country, String logo,
                                                  String slogan, String head_quaters, String website, String established) {
        String requestbody = "{\n" +
                "    \"id\": " + id + ",\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"country\": \"" + Country + "\",\n" +
                "    \"logo\": \"" + logo + "\",\n" +
                "    \"slogan\": \"" + slogan + "\",\n" +
                "    \"head_quaters\": \"" + head_quaters + "\",\n" +
                "    \"website\": \"" + website + "\",\n" +
                "    \"established\": \"" + established + "\"\n" +
                "}";
        return requestbody;
    }

    /* To pass request body Payload using map */

    public static Map<String, Object> postCreateAirLineUsingMap(String id, String name, String Country, String logo,
                                                                String slogan, String head_quaters, String website, String established) {
        Map<String, Object> requestPayLoad = new HashMap<>();
        requestPayLoad.put("id", id);
        requestPayLoad.put("name", name);
        requestPayLoad.put("Country", Country);
        requestPayLoad.put("logo", logo);
        requestPayLoad.put("slogan", slogan);
        requestPayLoad.put("head_quaters", head_quaters);
        requestPayLoad.put("website", website);
        requestPayLoad.put("established", established);
        return requestPayLoad;
    }
}
