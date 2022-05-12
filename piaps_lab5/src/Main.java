import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

        Context context = new Context();
        System.out.println("********************************************\n");
        Expression expression = context.evaluate(text);
        for (String s : text) {
            System.out.println(s);
        }

    }
}

