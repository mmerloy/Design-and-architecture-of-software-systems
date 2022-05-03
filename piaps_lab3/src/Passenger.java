enum ClassOfPassenger{FirstClass, BusinessClass, EconomyClass}

public class Passenger implements Component {

    String name;
    ClassOfPassenger classOfPassenger;
    int weightOfLuggage;
    int seatInPlane;

    Passenger(String name, ClassOfPassenger classOfPassenger, int weightOfLuggage, int seatInPlane){
        this.name = name;
        this.classOfPassenger = classOfPassenger;
        this.weightOfLuggage = weightOfLuggage;
        this.seatInPlane = seatInPlane;
    }

    @Override
    public void ShowHuman() {
        System.out.println(name + " " + classOfPassenger + " " + weightOfLuggage+" "+seatInPlane);
    }

}


