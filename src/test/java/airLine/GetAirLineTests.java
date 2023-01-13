package airLine;

import airLineAPI.AirLineApis;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.*;
import static org.testng.Assert.assertEquals;

public class GetAirLineTests extends AirLineApis {

    private static final Random random = new Random();
    private List<Integer> ticketIds = new ArrayList<>();
    private static final Map<String, Object> JsonRequestBody = Payloads.postCreateAirLineUsingMap(String.valueOf(random.nextInt() & Integer.MAX_VALUE), "India Airways", "India", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
            "From India", "Delhi, India", "www.indiaairways.com", "1991");

    private static final Map<String, Object> JsonRequest = Payloads.postCreateAirLineUsingMap(String.valueOf(random.nextInt() & Integer.MAX_VALUE), "Sri Lankan Airways", "Sri Lanka", "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
            "From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1992");


    @Test(priority = 1)
    public void createAirLineTicket() {
        Response response = createAirLineTicketId(JsonRequestBody, new HashMap<>());
        validateCreateAirLineTicket(Integer.parseInt(String.valueOf(response.getStatusCode())), 200);
        int customerTicketId = response.getBody().jsonPath().get("id");
        System.out.println("Ticket Id is : "+customerTicketId);

    }

      /* End to end flow */

    @Test(priority = 2)
    public void getAirLineTicketId() {

        /* Creating Airline ticket using POST call  */

        Response createTaskIdrResponse = createAirLineTicketId(JsonRequest, new HashMap<>());
        validateCreateAirLineTicket(Integer.parseInt(String.valueOf(createTaskIdrResponse.getStatusCode())), 200);
        int ticketId = createTaskIdrResponse.getBody().jsonPath().get("id");
        System.out.println(ticketId);
        ticketIds.add(ticketId);

        System.out.println(ticketIds.get(0));

        /* Validating  Airline ticket using GET  call  */

        Response response = AirLineApis.getAirLineById(ticketIds.get(0), new HashMap<>());
        int resp = response.getBody().jsonPath().get("id");
        System.out.println(resp);
        int AirLineTicketId = response.getBody().jsonPath().get("id");
        validateOAirLineTicketId(ticketId, AirLineTicketId);

    }


    @Step("Validate Status of Post Create Airline id ")
    private void validateCreateAirLineTicket(int actualStatus, int expectedStatus) {
        assertEquals(actualStatus, expectedStatus);
    }

    @Step("Validate AirLineTicket Id after creating post call ")
    private void validateOAirLineTicketId(final Integer actualTicketIds, final Integer expectedTicketIds) {
        assertEquals(actualTicketIds, expectedTicketIds);
    }
}

