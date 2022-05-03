
import java.util.ArrayList;

public class BusinessClassPassenger extends Composite {
    private ArrayList<Passenger> businessClassPassengers = new ArrayList<>();
    private int maxFreeWeight = 35;

    public ArrayList<Passenger> getBusinessClassPassengers(){
        return businessClassPassengers;
    }

    public void addBusinessClassPassenger(Passenger human){
        if((human.classOfPassenger.equals(ClassOfPassenger.BusinessClass)) && (human.weightOfLuggage <= maxFreeWeight)){
            businessClassPassengers.add(human);
        }else{
            System.out.println("Error, not added");
        }
    }

    public void removeBusinessClassPassenger(Component component){
        businessClassPassengers.remove(component);
    }

    @Override
    public void ShowHuman() {
        for (Component component : businessClassPassengers){
            component.ShowHuman();
        }
    }
}