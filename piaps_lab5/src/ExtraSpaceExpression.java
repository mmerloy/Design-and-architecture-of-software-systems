import java.util.ArrayList;

public class ExtraSpaceExpression implements Expression
{
    //можно вынести в метод базового класса
    public ArrayList<String> interpret(ArrayList<String> text)
    {
        for (int i = 0; i < text.size(); i++)
        {
            text.set(i , text.get(i).replaceAll("\\(\\s+", "("));
            text.set(i , text.get(i).replaceAll("\\s+\\)", ")"));
            text.set(i , text.get(i).replaceAll("\\s+,", ", "));//можно и в одно
            text.set(i , text.get(i).replaceAll("\\s+\\.", ". "));

            text.set(i , text.get(i).replaceAll("\\s{2,}", " "));
        }
        return text;
    }
}