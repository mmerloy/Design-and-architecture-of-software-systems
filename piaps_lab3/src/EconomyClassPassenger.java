
import java.util.ArrayList;

public class EconomyClassPassenger extends Composite {
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private int maxFreeWeight = 20;

    public ArrayList<Passenger> getPassengers(){
        return passengers;
    }

    public void addEconomyClassPassenger(Passenger human){
        if(human.classOfPassenger.equals(ClassOfPassenger.EconomyClass) && (human.weightOfLuggage <= maxFreeWeight)){
            passengers.add(human);
        }else{
            System.out.println("Error, not added");
        }
    }

    public void removeEconomyClassPassenger(Component component){
        passengers.remove(component);
    }
    @Override
    public void ShowHuman() {
        for (Component component : passengers){
            component.ShowHuman();
        }
    }
}