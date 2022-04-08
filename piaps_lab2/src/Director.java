import builders.*;
import passengers.*;

public class Director
{

    public void createBusTrip(Builder builder)
    {
        Passenger passenger1 = new Passenger();
        builder.boardPassenger(passenger1);
        builder.startTheRide();
    }

    public void createAirplaneTrip(Builder builder)
    {
        Passenger passenger2 = new Passenger();
        builder.boardPassenger(passenger2);
        builder.startTheRide();
    }

    public void createTaxiTrip(Builder builder)
    {
        Passenger passenger3 = new Passenger();
        builder.boardPassenger(passenger3);
        builder.startTheRide();
    }




}