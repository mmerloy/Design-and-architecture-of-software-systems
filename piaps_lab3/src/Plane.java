import java.util.ArrayList;

public class Plane extends Composite
{
    private int maxWeight;
    private int maxCountPilot = 2;
    private int maxCountStewardess = 6;
    private int maxSeat;

    private int countPilotsOnBoard = 0;
    private int countStewardessesOnBoard = 0;
    private int countPassengersOnBoard = 0;

    private int countFirstClass = 0;
    private int countBusinessClass = 0;
    private int countEconomyClass = 0;

    public ArrayList<Component> AllOnBoard = new ArrayList<>();

    public ArrayList<Component> removedLuggageComponent = new ArrayList<>();

    public void addPilot(Pilot pilot){
        countPilotsOnBoard++;
        if (countPilotsOnBoard <=maxCountPilot) {
            this.AllOnBoard.add(pilot);
        }
        else
            System.out.println("Pilots full");
    }

    public void addStewardess(Stewardess stewardess){
        countStewardessesOnBoard++;
        if(countStewardessesOnBoard <=maxCountStewardess) {
            this.AllOnBoard.add(stewardess);
        }
        else
            System.out.println("Stewardesses full");
    }

    //посадить в самолет всех пассажиров
    public void addPassengers( ArrayList<Passenger> firstClassPassenger,
                               ArrayList<Passenger> businessClassPassenger,
                               ArrayList<Passenger> economyClassPassenger){
        int i=0;
        for (Component pass : firstClassPassenger) {
            if(i==10)
                break;
            AllOnBoard.add(pass);
            countFirstClass++;
            i++;
        }
        for(Component pass : AllOnBoard){
            if(firstClassPassenger.contains(pass))
                firstClassPassenger.remove(pass);
        }

        i=0;
        for (Component pass : businessClassPassenger) {
            if(i==20)
                break;
            AllOnBoard.add(pass);
            countBusinessClass++;
            i++;
        }
        for(Component pass : AllOnBoard){
            if(businessClassPassenger.contains(pass))
                businessClassPassenger.remove(pass);
        }

        i=0;
        for (Component pass : economyClassPassenger) {
            if(i == maxSeat - 30)
                break;
            AllOnBoard.add(pass);
            countEconomyClass++;
            i++;
        }
        for(Component pass : AllOnBoard){
            if(economyClassPassenger.contains(pass))
                economyClassPassenger.remove(pass);
        }

        for(Component pass :AllOnBoard){
            if(pass.getClass()==Passenger.class)
                countPassengersOnBoard++;
        }
    }

    public void removePassenger(int seat){
        for(Component pass : AllOnBoard){
            if((pass instanceof Passenger)&&(((Passenger) pass).seatInPlane==seat)&&(((Passenger) pass).classOfPassenger == ClassOfPassenger.EconomyClass)){
                AllOnBoard.remove(pass);
                break;
            }
        }
    }

    //конструктор для создания самолета
    public Plane(int maxWeight, int maxSeat){
        this.maxWeight = maxWeight;
        this.maxSeat = maxSeat;
    }

    //сеттер максимального веса самолета
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    //подсчет суммы веса всего багажа
    int getSumWeight(){
        int sumWeight = 0;
        for (Component passenger : AllOnBoard){
            if (passenger.getClass()==Passenger.class){
                sumWeight+=((Passenger) passenger).weightOfLuggage;
            }
        }
        return sumWeight;
    }

    int getOverWeight(){
        if(maxWeight >= getSumWeight()) {
            return 0;
        }else{
            return getSumWeight()-maxWeight;
        }
    }

    //снимаем багаж с рейса
    public void removeLuggage(){
        for(Component pass : AllOnBoard) {
            if (getSumWeight() > maxWeight) {
                if (pass.getClass().equals(Passenger.class)) {
                    if (((Passenger) pass).classOfPassenger.equals(ClassOfPassenger.EconomyClass)) {
                        removedLuggageComponent.add(pass);
                        ((Passenger) pass).weightOfLuggage = 0;
                    }
                }
            }
        }
    }

    public boolean isPlaneReadyToFly(){
        if(maxWeight < getSumWeight())
        {
            System.out.println("Plane have overweight");
            return false;
        }
        else if(maxCountPilot!=countPilotsOnBoard)
        {
            System.out.println("Plane havent pilots");
            return false;
        }
        else if(maxCountStewardess!=countStewardessesOnBoard){
            System.out.println("Plane havent stewardesses");
            return false;
        }else{
            System.out.println("Plane ready to plain");
            return true;
        }
    }

    public String toString(){
        String str="";
        str+="Count of pilots: "+ countPilotsOnBoard +"\n"+
                "Count of stewardesses: "+countStewardessesOnBoard+"\n"+
                "Count of passengers: "+countPassengersOnBoard+"\n"+
                "CountFirstClass: " + countFirstClass + "\n"+
                "CountBusinessClass: " + countBusinessClass + "\n"+
                "CountEconomyClass: " + countEconomyClass + "\n"+
                "Overweight: "+getOverWeight()+"\n"+
                "RemovedLuggageCount: "+ removedLuggageComponent.size()+"\n";
        return str;
    }

    public Component findBySeat(int num){
        for (Component pass : AllOnBoard) {
            if ((pass instanceof Passenger)&&(((Passenger) pass).seatInPlane == num)){
                return pass;
            }
        }
        return null;
    }

    @Override
    public void ShowHuman() {
        for (Component component : AllOnBoard){
            component.ShowHuman();
        }
    }

}