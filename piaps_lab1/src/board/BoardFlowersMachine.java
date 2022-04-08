package board;

import drivers.BusDriver;
import drivers.Driver;
import drivers.FlowersDriver;
import passengers.BusPassenger;
import passengers.Flowers;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.random;

public class BoardFlowersMachine extends BoardAnyCar
{
    protected ArrayList <Flowers> flowers;
    protected ArrayList <FlowersDriver> drivers;

    public BoardFlowersMachine()
    {
        super();
        passengerLimit = 100;
        drivers = new ArrayList <FlowersDriver> (driverLimit);
        flowers = new ArrayList <Flowers> (passengerLimit);

    }

    //загрузить водителя
    public int boardDriver()
    {
        if (!start)
        {
            new Random();
            System.out.println("Начало поездки " );
            if (drivers.size() < driverLimit)
            {
                for (int i = 0; i < random() * 2; i++) {
                    drivers.add(new FlowersDriver());
                }
                System.out.println("количество водителей : " + drivers.size());
            }
        }
        else
            System.out.println("Невозможно загрузить водителя");
        return drivers.size();
    }

    //загрузить пассажиров
    public int boardPassenger()
    {
        new Random();
        if (!start) {
            if (flowers.size() < passengerLimit)
            {
                for (int i = 0; i < random() * 150; i++) {
                    flowers.add(new Flowers());
                }
                System.out.println("количество цветов : " + flowers.size());
            }
        }
        else
            System.out.println("Невозможно загрузить цветы!");
        return flowers.size();
    }

    //проверка наличия водителя
    protected boolean checkDriver()
    {
        if (drivers.size() > driverLimit ){
            System.out.println(" должно быть не больше 1 водителя");
            return false;}
        if (drivers.size() == 0){
            System.out.println(" не может не быть водителей");
            return false;}
        else
            return true;
    }

    //проверка наличия пассажиров
    protected boolean checkPassenger()
    {
        if (flowers.size() > passengerLimit ){
            System.out.println("должно быть не больше 100 букетов цветов");
            return false;}
        if (flowers.size() == 0){
            System.out.println("Должно быть больше цветов");
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
