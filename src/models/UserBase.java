package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import models.titles.Title;
import models.users.*;

public class UserBase {
    private Map<String, User> database = new HashMap<String, User>();

    private void readFile(String filename) {
        System.out.println("Lendo arquivo: " + filename);
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                User u;
                String[] parts = line.split(";");
                String username = parts[1];
                int age         = Integer.parseInt(parts[2]);
                if(parts[0] == "professor") {
                    u = new Teacher(username, age);
                }
                else if(parts[0] == "adm") {
                    u = new Administrator(username, age);
                }
                // Aluno por default
                else {
                    u = new Student(username, age);
                }
                this.database.put(username, u);
            }
        } catch (IOException e) {
            System.out.println("Erro no arquivo\n" + e.getMessage());
        }
    }

    public UserBase(String filename) {
        this.readFile(filename);
    }
}
