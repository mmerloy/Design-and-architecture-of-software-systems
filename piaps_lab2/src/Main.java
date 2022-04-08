import builders.AirplaneBuilder;
import builders.BusBuilder;
import builders.TaxiBuilder;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();

        TaxiBuilder taxi = new TaxiBuilder();
        BusBuilder bus = new BusBuilder();
        AirplaneBuilder airplane = new AirplaneBuilder();

        System.out.println("1 запуск");
        director.createTaxiTrip(taxi);
        System.out.println();
        System.out.println("2 запуск");
        director.createBusTrip(bus);
        System.out.println();
        System.out.println("3 запуск");
        director.createAirplaneTrip(airplane);

    }

}