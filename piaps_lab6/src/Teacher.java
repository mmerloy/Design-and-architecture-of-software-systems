import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teacher implements Observer {
    private final List<Observer> observers = new ArrayList<>();

    private final String name;
    private final String subject;
    private int currentPerfomance;

    public Teacher(String name, String subject) {
        this.subject = subject;
        this.name = name;
        this.currentPerfomance = 0;
    }

    public Teacher() {
        this.name = "Teacher name";
        this.subject = "Default subject";
        this.currentPerfomance = 0;
    }

    public void FillPerfomance() {
        Random random = new Random();
        this.currentPerfomance = random.nextInt(1, 5);
    }

    @Override
    public String Update() {
        String view = "";
        if (this.currentPerfomance == 0) {
            view = "Teacher " + this.name + " didn't give perfomance";
        } else {
            view = "Teacher " + this.name + ", " + this.subject + " - " + this.currentPerfomance;
        }
        return view;

    }
}