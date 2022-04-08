package board;

import drivers.*;
import passengers.*;
import java.util.*;

import static java.lang.Math.random;

public class BoardBus extends BoardAnyCar
{
    protected ArrayList <BusDriver> drivers;
    protected ArrayList <BusPassenger> passengers;


    public BoardBus()
    {
        super();
        passengerLimit = 30;
        drivers = new ArrayList <BusDriver> (driverLimit);
        passengers = new ArrayList <BusPassenger> (passengerLimit);

    }

    //загрузить водителя
    public int boardDriver()
    {
        if (!start)
        {
            new Random();
            System.out.println("Начало поездки на автобусе" );
            if (drivers.size() < driverLimit)
            {
                for (int i = 0; i < random() * 2; i++) {
                    drivers.add(new BusDriver());
                }
                System.out.println("количество водителей : " + drivers.size());
            }
        }
        else
            System.out.println("Невозможно загрузить водителя, автобус уже выехал!");
        return drivers.size();
    }

    //загрузить пассажиров
    public int boardPassenger()
    {
        new Random();
        if (!start) {
            if (passengers.size() < passengerLimit)
            {
                for (int i = 0; i < random() * 40; i++) {
                    passengers.add(new BusPassenger());
                }
                System.out.println("количество пассажиров : " + passengers.size());
            }
        }
        else
            System.out.println("Невозможно загрузить пассажира, автобус уже выехал!");
        return passengers.size();
    }

    //проверка наличия водителя
    protected boolean checkDriver()
    {
        if (drivers.size() > driverLimit ){
            System.out.println("В автобусе должно быть не больше 1 водителя");
            return false;}
        if (drivers.size() == 0){
            System.out.println("В автобусе не может быть водителей");
            return false;}
        else
            return true;
    }

    //проверка наличия пассажиров
    protected boolean checkPassenger()
    {
        if (passengers.size() > passengerLimit ){
            System.out.println("В автобусе должно быть до 30 человек");
            return false;}
        if (passengers.size() == 0){
            System.out.println("В автобусе должно быть больше человек");
            return false;}
        else
        return true;
    }

    public void startTheRide()
    {
        if (!start)//если машина еще не выехала
        {
            boardDriver();
            boardPassenger();
            if (checkPassenger() && checkDriver()) {
                System.out.println("Отлично , можем начинать поездку!");
                start = true;
            }
        }
        else System.out.println("автобус уже выехал :(");
    }

}