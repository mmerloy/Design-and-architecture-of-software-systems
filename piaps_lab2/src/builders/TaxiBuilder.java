package builders;

import drivers.Driver;
import passengers.Passenger;

import static drivers.TypeLicence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static java.lang.Math.random;

public class TaxiBuilder extends Builder
{
    private final List<Passenger> taxiPassengers;
    public int income = 0;//полученный доход с поездки
    protected ArrayList <Driver> drivers;
    Driver driver = new Driver();
    boolean hasChildSeat = false;

    public TaxiBuilder()
    {
        super();
        passengerLimit = 4;
        drivers = new ArrayList<>(driverLimit);
        taxiPassengers = new ArrayList<>(passengerLimit);
    }

    //загрузить водителя
    public void boardDriver(Driver driver)
    {
        if (!start)
        {
            new Random();
            System.out.println("Начало поездки на автобусе" );
            if (drivers.size() < driverLimit)
            {
                for (int i = 0; i < random() * 2; i++)
                {
                    drivers.add(new Driver());
                }
                System.out.println("количество водителей : " + drivers.size());
                System.out.println("лицензия водителя : " + driver.lt);
            }
            checkDriver();//проверка на нужного водителя
        }
        else
            System.out.println("Невозможно загрузить водителя, такси уже выехал!");

    }

    //загрузить пассажира
    public void boardPassenger(Passenger passenger)
    {
        if (!start)
        {
            Random random = new Random();
            if (taxiPassengers.size() < passengerLimit)
            {
                for (int i = 0; i < random.nextInt(passengerLimit) ; i++)
                {
                    taxiPassengers.add(new Passenger());
                }
                System.out.println("количество пассажиров : " + taxiPassengers.size());
                System.out.println("тип пассажира : " + passenger.pt);
            }
            checkPassenger();//проверка на нужного водителя
        }
        else
            System.out.println("Невозможно загрузить пассажира, такси уже выехал!");

    }

    //проверка наличия водителя с нужной лицензией
    protected boolean checkDriver()
    {
        if (drivers.size() > driverLimit )
        {
            System.out.println("В автобусе должно быть не больше 1 водителя");
            return false;
        }
        if (drivers.size() == 0)
        {
            System.out.println("В автобусе не может не быть водителей");
            return false;
        }
        else if (drivers.size() == 1)
        {
            //if(Driver.driver.lt.equals(B))//должно быть что-то такое
            if (driver.lt == T) //!!
            {
                System.out.println("Похоже все условия начала поездки соблюдены");
                return true;
            }
            else
            {
                System.out.println("Похоже лицензия вашего водителя не позволяет начать поездку(");
                return false;
            }
        }
        return true;
    }

    //проверка наличия пассажиров
    protected boolean checkPassenger()
    {
        //проверка наличия пассажиров
        if (taxiPassengers.size() > passengerLimit) {
            System.out.println("В такси должно быть до 4 человек");
            return false;
        }
        if (taxiPassengers.size() == 0) {
            System.out.println("В такси должно быть больше человек");
            return false;
        }
        return true;
    }

    //добавление пассажиров в автобус
    public boolean addPassenger(Passenger passenger)
    {
        //проверка наличия пассажиров
        if (taxiPassengers.size() > passengerLimit )
        {
            System.out.println("В такси должно быть до 4 человек");
            return false;
        }
        if (taxiPassengers.size() == 0)
        {
            System.out.println("В такси должно быть больше человек");
            return false;
        }

        else
        {
            switch (passenger.pt)
            {
                case CHILD -> {
                    addChildSeat();
                    this.taxiPassengers.add(passenger);
                }
                case ADULT -> {
                    income += 100;
                    this.taxiPassengers.add(passenger);
                }
            }
            return true;
        }
    }


    public void startTheRide()
    {
        if (!start)//если машина еще не выехала
        {
            Passenger passenger = new Passenger();
            boardDriver(driver);
            boardPassenger(passenger);
            addPassenger(passenger);
            if (checkPassenger() && checkDriver())
            {
                System.out.println("Отлично , можем начинать поездку!");
                start = true;
            }
        }
        else
            System.out.println("Такси уже уехало. Общий доход: " + income);

    }

    public void addChildSeat()
    {
        this.hasChildSeat = true;
    }

}





