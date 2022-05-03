

import java.util.ArrayList;
import java.util.Arrays;

public class PassengersClass {
    FirstClassPassenger firstClassPassenger = new FirstClassPassenger();
    BusinessClassPassenger businessClassPassenger = new BusinessClassPassenger();
    EconomyClassPassenger economyClassPassenger = new EconomyClassPassenger();

    public ArrayList<Passenger> addPassenger(String type, int num){
        if(type.equals("Economy")){
            for (int i = 0; i < num; i++) {
                economyClassPassenger.addEconomyClassPassenger(new Passenger("Alina",
                        ClassOfPassenger.EconomyClass, 15, (i+1)%150));
            }
            return economyClassPassenger.getPassengers();
        }
        else if(type.equals("Business")){
            for (int i = 0; i < num; i++) {
                businessClassPassenger.addBusinessClassPassenger(new Passenger("Anastasia",
                        ClassOfPassenger.BusinessClass, 15, (i+1)%20));
            }
            return businessClassPassenger.getBusinessClassPassengers();
        }
        else {
            for (int i = 0; i < num; i++) {
                firstClassPassenger.addFirstClassPassenger(new Passenger("Alla",
                        ClassOfPassenger.FirstClass, 15, (i+1)%10));
            }
            return firstClassPassenger.getFirstClassPassengers();
        }
    }

    public void removePassenger(String type, int num){
        if(type.equals("Economy"))
        {
            System.out.println(economyClassPassenger + "++");
            // economyClassPassenger.removeEconomyClassPassenger(economyClassPassenger.getPassengers().get(num));

//            for (int i = 0; i < num; i++) {
//                economyClassPassenger.removeEconomyClassPassenger(economyClassPassenger.getEconomyClassPassengers().get(i));
//            }
        }
        else if(type.equals("Business")){
            for (int i = 0; i < num; i++) {
                businessClassPassenger.removeBusinessClassPassenger(businessClassPassenger.getBusinessClassPassengers().get(i));
            }
        }
        else {
            for (int i = 0; i < num; i++) {
                firstClassPassenger.removeFirstClassPassenger(firstClassPassenger.getFirstClassPassengers().get(i));
            }
        }
        //return num;
    }
}