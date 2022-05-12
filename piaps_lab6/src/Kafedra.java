import java.util.ArrayList;

public class Kafedra implements Observer
{
    public ArrayList<Observer> teachers;// = new ArrayList<>();
    private final String name;

    public Kafedra ()
    {
        this.name = "Default Departament";
        teachers = new ArrayList<>();
    }

    public Kafedra(String name)
    {
        this.name = name;
        teachers = new ArrayList<>();
    }

    public Kafedra(String name, ArrayList<Observer> observers)
    {
        this.teachers = observers;
        this.name = name;
    }

    public void AddTeachers(Observer teacher)
    {
        teachers.add(teacher);
    }

    public void removeTeachers(Observer teacher)
    {
        teachers.remove(teacher);
    }

    @Override
    public String Update()
    {
        StringBuilder view = new StringBuilder("Kafedra " + this.name + "\n");
        for (Observer observer : teachers)
        {
            view.append(observer.Update()).append("\n");
        }
        return view.toString();
    }
}
