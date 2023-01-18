package airLine;

import airLineAPI.PassengerServiceApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojoApiData.PassengerPojo;
import org.json.*;
import java.util.HashMap;
import java.util.Random;


public class CustomerPassengerTests extends PassengerServiceApi {


    private static final Random random = new Random();
    private  static final int trips =random.nextInt() & Integer.MAX_VALUE;
    @Test(priority = 1)
    public void getPassengerId() {

        /* Creating Passenger  ticket using POST call  */
        PassengerPojo JsonRequest = new PassengerPojo("XYZ",trips ,56 );
        JSONObject jsonpayload = new JSONObject(JsonRequest);
        Response createTaskIdrResponse = createAirLineTicketId(String.valueOf(jsonpayload), new HashMap<>());
        System.out.println(createTaskIdrResponse.getBody().prettyPrint());
    }
}