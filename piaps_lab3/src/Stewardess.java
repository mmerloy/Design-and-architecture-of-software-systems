public class Stewardess implements Component {
    String name;

    Stewardess(String name){
        this.name = name;
    }
    @Override
    public void ShowHuman() {
        System.out.println("Stewardess "+name);
    }
}