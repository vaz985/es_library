package models.users;

import models.titles.Title;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private Set<Title> rented;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void addTitle(Title t) {
        rented.add(t);
    }

    public void remTitle(Title t) {
        rented.remove(t);
    }
}
