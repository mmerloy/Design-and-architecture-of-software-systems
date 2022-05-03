import java.util.ArrayList;

public class Composite implements Component
{
    public ArrayList<Component> components = new ArrayList<>();


    @Override
    public void ShowHuman() {
        for (int i = 0;i < components.size();i++)
        {
            components.get(i).ShowHuman();
        }

    }

}
