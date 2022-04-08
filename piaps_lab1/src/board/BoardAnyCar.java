package board;

import passengers.Passenger;
import java.util.ArrayList;

public abstract class BoardAnyCar
{
    boolean start ;
    protected int passengerLimit; //лимит пассажиров
    protected int driverLimit; //лимит водителей

    public BoardAnyCar()
    {
        start = false;
        driverLimit = 1; //для всех машин максимум один водитель
    }

    protected ArrayList<Passenger> passengers;
    public    ArrayList    <Passenger> getPassengers()     {   return passengers;}

    public int getDriverLimit()     { return driverLimit;}
    public int getPassengerLimit()  {return passengerLimit;}

    //загрузить водителя
    public abstract int boardDriver();

    //загрузить пассажиров
    public abstract int boardPassenger();

    //проверка наличия пассажиров
    protected abstract boolean checkPassenger();

    //проверка для водителей
    protected abstract boolean checkDriver();

    public abstract void startTheRide();

}