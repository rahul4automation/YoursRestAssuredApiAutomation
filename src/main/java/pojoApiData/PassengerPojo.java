package pojoApiData;

public class PassengerPojo {


    private String name;
    private int trips;
    private int airline;

    public void setName(String name) {
        this.name = name;
    }

    public void setTrips(int trips) {
        this.trips = trips;
    }

    public void setAirline(int airline) {
        this.airline = airline;
    }


    public String getName() {
        return name;
    }

    public int getTrips() {
        return trips;
    }

    public int getAirline() {
        return airline;
    }


    public PassengerPojo(String name, int trips, int airline) {
        this.name = name;
        this.trips = trips;
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "PassengerPojo{" +
                "name:'" + name + '\'' +
                ", trips:" + trips +
                ", airline:" + airline +
                '}';
    }

}
