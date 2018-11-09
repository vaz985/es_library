package views;

import javax.swing.*;

import users.Administrator;
import users.Student;
import users.Teacher;
import users.User;

public class ViewSearch extends ViewBase {

    private JButton searchButton  = new JButton("Search");
    private JButton rentedButton  = new JButton("Rented");
    private JButton addUserButton = new JButton("Add Usuario");
    private JButton addBookButton = new JButton("Add Livro");

    private User user;

    public ViewSearch(Administrator admin) {

        super(admin.getName() + " (administrador)");
        setUser(admin);

        optionsPanel.add(searchButton);
        optionsPanel.add(rentedButton);
        optionsPanel.add(addUserButton);
        optionsPanel.add(addBookButton);

    }

    public ViewSearch(Student student) {

        super(student.getName() + " (estudante)");
        setUser(student);

        optionsPanel.add(searchButton);
        optionsPanel.add(rentedButton);

    }

    public ViewSearch(Teacher teacher) {

        super(teacher.getName() + " (professor)");

        optionsPanel.add(searchButton);
        optionsPanel.add(rentedButton);

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
