//Обеспечить контроль загрузки и готовности к отправлению автобусов и такси.
//Водитель такси и автобуса имеют права разной категории. Без водителя машина не
//поедет. Два водителя в одну машину сесть не могут. Без пассажиров машины не
//поедут. Есть лимит загрузки машин. Для автобуса 30 чел. Для такси -4 чел.
//Есть разница между пассажирами автобуса и такси.
//Для автобуса: три категории пассажиров - взрослый, льготный, ребенок - разная
//стоимость билета.
//Для такси: взрослый и ребенок. Необходимо детское кресло


package builders;

import drivers.*;
import passengers.*;

public abstract class Builder
{
    boolean start ;
    protected int passengerLimit; //лимит пассажиров
    protected int driverLimit; //лимит водителей

    //конструктор какого-то транспорта
    public Builder()
    {
        start = false;
        driverLimit = 1; //для всех машин максимум один водитель
    }

    //загрузить водителя
    public void boardDriver(Driver driver){};

    //проверка наличия водителя с нужной лицензией
    protected boolean checkDriver() {
        return false;
    }

    //проверка наличия пассажиров
    protected boolean checkPassenger(){
        return false;
    };

    public void boardPassenger(Passenger passenger)
    {

    };

    //метод, который добавляет пассажиров в Такси
    public boolean addPassenger(Passenger passenger){

        return false;
    };

    public void addChildSeat(){

    };

    public void addLedenec(){

    };

    public void addVino(){

    };

    //метод, который проверяет условия для начала поездки
    public void startTheRide(){};



}
