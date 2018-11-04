package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.nashorn.internal.objects.NativeJava;
import models.titles.Title;
import models.users.*;

public class UserBase {
    private Map<String, User> database = new HashMap<String, User>();
    private boolean valid_userbase = false;

    private void readFile(String filename) {
        System.out.println("Lendo arquivo: " + filename);
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                User u;
                String[] parts = line.split(";");
                String type     = parts[0];
                String username = parts[1];
                int age         = Integer.parseInt(parts[2]);
                if(type.equals("professor")) {
                    u = new Teacher(username, age);
                }
                else if(type.equals("adm")) {
                    u = new Administrator(username, age);
                }
                // Aluno por default
                else {
                    u = new Student(username, age);
                }
                this.database.put(username, u);
                this.valid_userbase = true;
            }
        } catch (IOException e) {
            System.out.println("Erro no arquivo\n" + e.getMessage());
        }
    }

    public UserBase(String filename) {
        this.readFile(filename);
        if(this.valid_userbase)
            System.out.println("Userbase initialized");
    }

    public java.util.Collection<User> getCollection() {
        return this.database.values();
    }

    public String[] getCollectionNames() {
        List<String> names = new ArrayList<String>();
        for(User u : this.getCollection()) {
            names.add(u.getName());
        }
        return names.toArray(new String[names.size()]);
    }

    public User getUser(String name) {
        if(this.database.containsKey(name))
            return this.database.get(name);
        return null;
    }
}
