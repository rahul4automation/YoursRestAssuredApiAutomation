package airLine;

public class Payloads {

    /* POST Method to Create AirLine using string parametrize payload */
    public static String postCreateAirLinePayload(String id, String name, String Country, String logo,
                                                  String slogan, String head_quaters, String website, String established){
        String requestbody ="{\n" +
                "    \"id\": "+id+",\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"country\": \""+Country+"\",\n" +
                "    \"logo\": \""+logo+"\",\n" +
                "    \"slogan\": \""+slogan+"\",\n" +
                "    \"head_quaters\": \""+head_quaters+"\",\n" +
                "    \"website\": \""+website+"\",\n" +
                "    \"established\": \""+established+"\"\n" +
                "}";
        return requestbody;
    }
}
