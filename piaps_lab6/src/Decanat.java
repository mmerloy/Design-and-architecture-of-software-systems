import java.util.ArrayList;
import java.util.List;

public class Decanat implements Observed
{

    ArrayList<Observer> observers = new ArrayList<Observer>();

    public Decanat()
    {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void addObserver(Observer a)
    {
    observers.add(a);
    }

    @Override
    public void removeObserver(Observer a)
    {
    observers.remove(a);
    }

    @Override
    public void notifyObserver()
    {
        for ( Observer a : observers)
        {
            System.out.println(a.Update());
        }
    }
}