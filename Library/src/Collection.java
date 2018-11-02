import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Collection {
    private Map<String, Title> database;
    private boolean valid_colection = false;

    private void read_file(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String title_name = parts[0];
                String author     = parts[1];
                int year          = Integer.parseInt(parts[2]);
                int quantity      = Integer.parseInt(parts[3]);
                int max_allowance = 5;
                Title t = new Title(title_name, author, year, quantity, max_allowance);
                this.database.put(title_name, t);
            }
            this.valid_colection = true;
        }
        catch (IOException e) {
            System.out.println("Erro no arquivo\n" + e.getMessage());
        }
    }

    public Collection(String filename) {
        this.read_file(filename);
        if(this.valid_colection)
            System.out.println("Database initialized");
    }
}