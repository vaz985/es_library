package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import models.titles.*;

public class Collection {
    private Map<String, Title> database = new HashMap<String, Title>();
    private boolean valid_colection = false;

    private void readFile(String filename) {
        System.out.println("Lendo arquivo: " + filename);
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String title_name = parts[0];
                String author = parts[1];
                int year = Integer.parseInt(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                Title t = new Title(title_name, author, year, quantity);
                this.addTitle(t);
            }
            this.valid_colection = true;
        } catch (IOException e) {
            System.out.println("Erro no arquivo\n" + e.getMessage());
        }
    }

    public void addTitle(Title t) {
        this.database.put(t.getTitle_name(), t);
    }

    public void removeTitle(String titleName) {
        this.database.remove(titleName);
    }

    public Title getTitle(String titleName) {
        if (this.database.containsKey(titleName))
            return this.database.get(titleName);
        throw new NullPointerException();
    }

    public Collection(String filename) {
        this.readFile(filename);
        if (this.valid_colection)
            System.out.println("Database initialized");
    }

    public java.util.Collection<Title> getCollection() {
        return this.database.values();
    }

}