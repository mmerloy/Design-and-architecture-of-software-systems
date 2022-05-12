
public class Main {

    public static void main(String[] args)
    {
        Decanat decanat = new Decanat();

        Kafedra kafedra = new Kafedra("Кафедра1");
        Teacher teacher1 = new Teacher("Преподаватель1","Предмет1");
        Teacher teacher2 = new Teacher("Преподаватель2", "Предмет2");
        Teacher teacher3 = new Teacher("Преподаватель3", "Предмет3");

        kafedra.AddTeachers(teacher1);
        kafedra.AddTeachers(teacher2);
        kafedra.AddTeachers(teacher3);

        decanat.addObserver(kafedra);

        teacher1.FillPerfomance();
        teacher3.FillPerfomance();

        decanat.notifyObserver();

        System.out.println();

        kafedra.removeTeachers(teacher3);
        decanat.notifyObserver();
        System.out.println();
    }
}