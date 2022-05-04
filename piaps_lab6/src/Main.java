import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        Decanat decanat = new Decanat();

        Kafedra kafedra = new Kafedra("Spintech");
        Teacher teacher1 = new Teacher("Ivanov","DataBases");
        Teacher teacher2 = new Teacher("Petrov", "C++");
        Teacher teacher3 = new Teacher("Sidorov", "OpenMP");

        kafedra.AddTeachers(teacher1);
        kafedra.AddTeachers(teacher2);
        kafedra.AddTeachers(teacher3);

        decanat.addObserver(kafedra);

        teacher1.FillPerfomance();
        teacher3.FillPerfomance();

        decanat.notifyObserver();

        System.out.println();
    }
}