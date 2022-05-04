import java.util.ArrayList;

public class QuoteExpression implements Expression
{

    @Override
    public ArrayList<String> interpret(ArrayList<String> text)
    {
        for (int i = 0; i < text.size(); i++)
        {
            text.set(i , text.get(i).replaceAll("“", "<<"));
            text.set(i , text.get(i).replaceAll("”", ">>"));

        }
        return text;
    }
}