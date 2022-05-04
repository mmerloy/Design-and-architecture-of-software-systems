import java.util.ArrayList;

public class ExtraEnterExpression implements Expression
{

    public ArrayList<String> interpret(ArrayList<String> text)
    {
        //text.set(i, text.get(i).replaceAll("\r+", "\r"));
        int current_size = text.size();
        for (int i = 0; i < current_size; i++)
        {
            if (i+1 < current_size && text.get(i).isBlank() && text.get(i+1).isBlank() )
            {
                text.remove(i+1);
                --i;
                current_size --;
            }

        }


        //text.removeIf(String::isBlank);
        return text;
    }
}

