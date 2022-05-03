import java.util.ArrayList;

public class Main {



    public static void main(String[] args)
    {

        Plane plane1 = new Plane(550, 50);

        PassengersClass comp = new PassengersClass();

        plane1.addPassengers(comp.addPassenger("FirstClass",10),comp.addPassenger("Business",20),comp.addPassenger("Economy",20));
        plane1.removeLuggage();

        plane1.addPilot(new Pilot("Pavel"));
        plane1.addPilot(new Pilot("Nicolay"));

        plane1.addStewardess(new Stewardess("Petr"));
        plane1.addStewardess(new Stewardess("Nina"));
        plane1.addStewardess(new Stewardess("Olga"));
        plane1.addStewardess(new Stewardess("Maria"));
        plane1.addStewardess(new Stewardess("Sasha"));
        plane1.addStewardess(new Stewardess("Elda"));

        System.out.println("Plane1");
        //System.out.println(plane1);
        plane1.isPlaneReadyToFly();
        plane1.ShowHuman();

//        System.out.println("\nPlane2");
//        //System.out.println(plane2);
//        plane2.isPlaneReadyToFly();
//        //plane2.ShowHuman();
//
//        comp.economyClassPassenger.removeEconomyClassPassenger(
//                comp.economyClassPassenger.getEconomyClassPassengers().get(5)
//        );
        //comp.removePassenger("Economy",5);
        plane1.removePassenger(5);
        plane1.ShowHuman();

    }
}