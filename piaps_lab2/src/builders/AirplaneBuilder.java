package builders;

import drivers.Driver;
import passengers.Passenger;

import static drivers.TypeLicence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static java.lang.Math.random;

public class AirplaneBuilder extends Builder
{
    private List<Passenger> airplanePassengers = new ArrayList<>();
    public int ledenec = 0;//раздача леденцов для детей
    public int vino = 0;//раздача вина для взрослых
    protected ArrayList <Driver> drivers;
    Driver driver = new Driver();

    public AirplaneBuilder()
    {
        super();
        passengerLimit = 100;
        drivers = new ArrayList<>(driverLimit);
        airplanePassengers = new ArrayList<>(passengerLimit);
    }

    //загрузить водителя
    public void boardDriver(Driver driver)
    {
        if (!start)
        {
            new Random();
            System.out.println("Начало полета на самолете" );
            if (drivers.size() < driverLimit)
            {
                for (int i = 0; i < random() * 2; i++)
                {
                    drivers.add(new Driver());
                }
                System.out.println("количество пилотов : " + drivers.size());
                System.out.println("лицензия пилота : " + driver.lt);
            }
            checkDriver();//проверка на нужного водителя
        }
        else
            System.out.println("Невозможно загрузить пилота, самолет уже улетел!");

    }

    //загрузить пассажира
    public void boardPassenger(Passenger passenger)
    {
        if (!start)
        {
            Random random = new Random();
            if (airplanePassengers.size() < passengerLimit)
            {
                for (int i = 0; i < random.nextInt(passengerLimit); i++)
                {
                    airplanePassengers.add(new Passenger());
                }
                System.out.println("количество пассажиров : " + airplanePassengers.size());
                System.out.println("тип пассажира : " + passenger.pt);
            }
            checkPassenger();//проверка пассажиров
        }
        else
            System.out.println("Невозможно загрузить пассажира, самолет уже улетел!");

    }

    //проверка наличия водителя с нужной лицензией
    protected boolean checkDriver()
    {
        if (drivers.size() > driverLimit )
        {
            System.out.println("В самолете должно быть не больше 1 пилота");
            return false;
        }
        if (drivers.size() == 0)
        {
            System.out.println("В самолете не может не быть пилотов");
            return false;
        }
        else if (drivers.size() == 1)
        {
            //if(Driver.driver.lt.equals(B))//должно быть что-то такое
            if (driver.lt == A) //!!
            {
                System.out.println("Похоже все условия начала полета соблюдены");
                return true;
            }
            else
            {
                System.out.println("Похоже лицензия вашего пилота не позволяет подняться в воздух(");
                return false;
            }
        }
        return true;
    }

    //проверка наличия пассажиров
    protected boolean checkPassenger()
    {
        //проверка наличия пассажиров
        if (airplanePassengers.size() > passengerLimit) {
            System.out.println("В самолете должно быть до 100 человек");
            return false;
        }
        if (airplanePassengers.size() == 0) {
            System.out.println("В самолете должно быть больше человек");
            return false;
        }
        return true;
    }

    //добавление пассажиров в автобус
    public boolean addPassenger(Passenger passenger)
    {
        //проверка наличия пассажиров
        if (airplanePassengers.size() > passengerLimit )
        {
            System.out.println("В самолете должно быть до 100 человек");
            return false;
        }
        if (airplanePassengers.size() == 0)
        {
            System.out.println("В самолете должно быть больше человек");
            return false;
        }

        else
        {
            switch (passenger.pt)
            {
                case CHILD -> {
                    addLedenec();
                    this.airplanePassengers.add(passenger);
                }
                case ADULT -> {
                    addVino();
                    this.airplanePassengers.add(passenger);
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
            addPassenger(passenger);
            if (checkPassenger() && checkDriver())
            {
                System.out.println("Отлично , можем начинать поездку!");
                start = true;
            }
        }
        else
            System.out.println("Самолет улетел " );

    }

    //раздача вина для взрослых
    public void addVino()
    {
        this.vino = vino + 5;
    }

    //раздача леденцов для детей
    public void addLedenec()
    {
        this.ledenec = ledenec + 1;
    }
}