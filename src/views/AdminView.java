package views;

import models.users.User;
import javax.swing.*;

public class AdminView extends BaseView{
    private JButton searchButton;
    private JButton rentedButton;
    private JButton addUserButton;
    private JButton addBookButton;

    public AdminView(User theUser) {

        super(theUser.getName() + " (Administrador)");

        searchButton = new JButton("Search");
        rentedButton = new JButton("Rented");
        addUserButton = new JButton("Add Usuario");
        addBookButton = new JButton("Add Livro");

        topPanel.add(searchButton);
        topPanel.add(rentedButton);
        topPanel.add(addUserButton);
        topPanel.add(addBookButton);

    }
}
