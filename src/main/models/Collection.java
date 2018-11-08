package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import models.titles.*;
import models.users.User;

public class Collection {
    private Map<String, Title> database = new HashMap<String, Title>();
    private Map<User, Set<Title>> rentedBooks = new HashMap<User, Set<Title>>();
    private boolean valid_colection = false;

    // Parse file for book titles
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

    public boolean avaliableTitle(Title t) {
        return t.getRented() < t.getQuantity();
    }

    public void rentTitle(User u, Title t) {
        t.increseRented();
        if(this.rentedBooks.containsKey(u)) {
            this.rentedBooks.get(u).add(t);
        }
        else {
            Set<Title> books = new HashSet<Title>();
            books.add(t);
            this.rentedBooks.put(u, books);
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
        return null;
    }

    // Empty constructor
    public Collection() {}

    public Collection(String filename) {
        this.readFile(filename);
        if (this.valid_colection)
            System.out.println("Database initialized");
    }

    public ArrayList<Title> getCollection() {
        return new ArrayList<Title>(this.database.values());
    }

    public String[] getCollectionNames() {
        List<String> names = new ArrayList<String>();
        for(Title t : this.getCollection()) {
            names.add(t.getTitle_name());
        }
        return names.toArray(new String[names.size()]);
    }

    public Map<String, Title> getDatabase() {
        return database;
    }

    public Map<User, Set<Title>> getRentedBooks() {
        return rentedBooks;
    }
}