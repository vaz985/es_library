package views;

import models.users.Administrator;
import models.users.Student;
import models.users.Teacher;
import models.users.User;

import javax.swing.*;

public class SearchView extends BaseView {
    private JButton searchButton  = new JButton("Search");
    private JButton rentedButton  = new JButton("Rented");
    private JButton addUserButton = new JButton("Add Usuario");
    private JButton addBookButton = new JButton("Add Livro");
    private User currentUser;

    public SearchView(Administrator theUser) {
        super(theUser.getName() + " (Administrador)");
        this.setCurrentUser(theUser);

        optionsPanel.add(searchButton);
        optionsPanel.add(rentedButton);
        optionsPanel.add(addUserButton);
        optionsPanel.add(addBookButton);
    }
    public SearchView(Student theUser) {
        super(theUser.getName() + " (estudante)");
        this.setCurrentUser(theUser);

        optionsPanel.add(searchButton);
        optionsPanel.add(rentedButton);
    }
    public SearchView(Teacher theUser) {
        super(theUser.getName() + " (professor)");

        optionsPanel.add(searchButton);
        optionsPanel.add(rentedButton);
    }
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
