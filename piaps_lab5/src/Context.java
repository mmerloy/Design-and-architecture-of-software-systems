import java.util.ArrayList;

public class Context
{
    Expression evaluate(ArrayList<String> text)
    {
        text = (new DefisExpression()).interpret(text);
        text = (new ExtraEnterExpression()).interpret(text);
        text = (new ExtraSpaceExpression()).interpret(text);
        text = (new QuoteExpression()).interpret(text);

        return null;
    }
}