package models;
import views.BaseView;
import views.StudentView;

import javax.swing.*;

public class Library {
    private Collection c;

    public static void main(String[] argv) {

        JFrame theView = new StudentView();

        theView.setVisible(true);

    }
}
