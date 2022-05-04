import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> text = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/TextFile"));
            String line = reader.readLine();
            while (line != null) {
                text.add(line);
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        text = (new DefisExpression()).interpret(text);
        text = (new ExtraEnterExpression()).interpret(text);
        text = (new ExtraSpaceExpression()).interpret(text);
        text = (new QuoteExpression()).interpret(text);
        System.out.println("---------------------");
        for (String s : text) {
            System.out.println(s);
        }
    }
}