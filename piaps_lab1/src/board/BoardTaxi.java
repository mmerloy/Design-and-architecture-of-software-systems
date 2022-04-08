package board;

import drivers.*;
import passengers.*;
import java.util.*;

import static java.lang.Math.random;

public class BoardTaxi extends BoardAnyCar
{
    protected ArrayList <TaxiDriver> drivers;
    protected ArrayList <TaxiPassenger> passengers;
    public BoardTaxi() {
        super();

        passengerLimit = 4;

        drivers = new ArrayList <TaxiDriver> (driverLimit);
        passengers = new ArrayList <TaxiPassenger> (passengerLimit);
    };


    //загрузить водителя
    public int boardDriver()
    {
        if (!start)
        {
            new Random();
            System.out.println("Начало поездки на такси" );
            if (drivers.size() < driverLimit)
            {
                for (int i = 0; i < random() * 2; i++) {
                    drivers.add(new TaxiDriver());
                }
                System.out.println("количество водителей : " + drivers.size());
            }
        }
        else
            System.out.println("Невозможно загрузить водителя, такси уже выехал!");
        return drivers.size();
    }

    //загрузить пассажиров
    public int boardPassenger()
    {
        new Random();
        if (!start) {
            if (passengers.size() < passengerLimit)
            {
                for (int i = 0; i < random() * 5; i++) {
                    passengers.add(new TaxiPassenger());
                }
                System.out.println("количество пассажиров : " + passengers.size());
            }
        }
        else
            System.out.println("Невозможно загрузить пассажира, такси уже выехал!");
        return passengers.size();
    }

    //проверка наличия водителя
    protected boolean checkDriver()
    {
        if (drivers.size() > driverLimit ){
            System.out.println("В такси должно быть не больше 1 водителя");
            return false;}
        if (drivers.size() == 0){
            System.out.println("В такси не может не быть водителей");
            return false;}
        else
            return true;
    }

    //проверка наличия пассажиров
    protected boolean checkPassenger()
    {
        if (passengers.size() > passengerLimit ){
            System.out.println("В такси должно быть до 4 человек");
            return false;}
        if (passengers.size() == 0){
            System.out.println("В такси должно быть больше человек");
            return false;}
        else
            return true;
    }

    public void startTheRide()
    {
        if (!start) //если машина еще не выехала
        {
            boardDriver();
            boardPassenger();
            if ( checkDriver() && checkPassenger()) {
                System.out.println("Отлично , можем начинать поездку");
                start = true;
            }
            else System.out.println("Нельзя начать поездку:(");
        }
        else System.out.println("такси уже выехал :(");
    }

}
