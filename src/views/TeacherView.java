package views;

import models.users.User;
import javax.swing.*;

public class TeacherView extends BaseView{
    private JButton searchButton;
    private JButton rentedButton;

    public TeacherView(User theUser) {

        super(theUser.getName() + " (professor)");

        searchButton = new JButton("Search");
        rentedButton = new JButton("Rented");

        topPanel.add(searchButton);
        topPanel.add(rentedButton);

    }
}
