public class Pilot implements Component {

    String name;
    Pilot(String name){
        this.name = name;
    }

    @Override
    public void ShowHuman() {
        System.out.println("Pilot " + name);
    }
}