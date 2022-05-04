import java.util.ArrayList;

public class DefisExpression implements Expression {

    @Override
    public ArrayList<String> interpret(ArrayList<String> text)
    {
        for (int i = 0; i < text.size(); i++)
        {
            text.set(i , text.get(i).replaceAll("-+", "—"));

        }
        return text;
    }
}