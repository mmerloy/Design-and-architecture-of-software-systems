import java.util.ArrayList;

public class FirstClassPassenger extends Composite {
    private ArrayList<Passenger> firstClassPassengers = new ArrayList<>();

    public ArrayList<Passenger> getFirstClassPassengers(){
        return firstClassPassengers;
    }

    public void addFirstClassPassenger(Passenger human){
        if(human.classOfPassenger.equals(ClassOfPassenger.FirstClass)){
            firstClassPassengers.add(human);
        }else{
            System.out.println("Error, not added");
        }
    }

    public void removeFirstClassPassenger(Component component){
        firstClassPassengers.remove(component);
    }


    @Override
    public void ShowHuman() {
        for(Component component : firstClassPassengers){
            component.ShowHuman();
        }
    }
}