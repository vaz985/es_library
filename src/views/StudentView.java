package views;
import models.users.User;

import javax.swing.*;
import java.awt.*;

public class StudentView extends BaseView {

    private JButton searchButton;
    private JButton rentedButton;

    public StudentView(User theUser) {

        super(theUser.getName() + " (estudante)");

        searchButton = new JButton("Search");
        rentedButton = new JButton("Rented");

        topPanel.add(searchButton);
        topPanel.add(rentedButton);

    }

}