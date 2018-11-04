package views;
import models.users.User;

import javax.swing.*;
import java.awt.*;

public class StudentView extends BaseView {

    private JButton searchButton;
    private JButton rentedButton;
    private User currentUser;

    public StudentView(User theUser) {

        super(theUser.getName() + " (estudante)");
        this.setCurrentUser(theUser);

        searchButton = new JButton("Search");
        rentedButton = new JButton("Rented");

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