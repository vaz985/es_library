package views;

import models.users.Administrator;
import models.users.Student;
import models.users.Teacher;
import models.users.User;

import javax.swing.*;

public class UserView extends BaseView {
    private JButton searchButton  = new JButton("Search");
    private JButton rentedButton  = new JButton("Rented");
    private JButton addUserButton = new JButton("Add Usuario");
    private JButton addBookButton = new JButton("Add Livro");
    private User currentUser;

    public UserView(Administrator theUser) {
        super(theUser.getName() + " (Administrador)");
        this.setCurrentUser(theUser);

        topPanel.add(searchButton);
        topPanel.add(rentedButton);
        topPanel.add(addUserButton);
        topPanel.add(addBookButton);
    }
    public UserView(Student theUser) {
        super(theUser.getName() + " (estudante)");
        this.setCurrentUser(theUser);

        topPanel.add(searchButton);
        topPanel.add(rentedButton);
    }
    public UserView(Teacher theUser) {
        super(theUser.getName() + " (professor)");

        topPanel.add(searchButton);
        topPanel.add(rentedButton);
    }
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
