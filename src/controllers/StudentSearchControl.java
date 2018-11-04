package controllers;

import models.Collection;
import models.Library;
import models.users.User;
import views.BaseView;
import views.StudentRentDialog;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSearchControl {

    private Collection theCollection;
    private BaseView theView;

    private String selectedItem;

    private Library model;
    private User currentUser;

    public StudentSearchControl(Library model, BaseView v, User currentUser) {
        this.model = model;
        this.currentUser = currentUser;

        theCollection = model.getC();
        theView = v;

        theView.drawList(theCollection.getCollectionNames(), new RentSelectionListener());
        theView.revalidate();
    }

    public class RentSelectionListener implements ListSelectionListener {
        public boolean exist = false;

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if(!listSelectionEvent.getValueIsAdjusting() && !exist) {
                selectedItem = theView.getSelectedItem();
                System.out.println("Item selected: " + selectedItem + Boolean.toString(listSelectionEvent.getValueIsAdjusting()));
                new StudentRentDialog(theCollection.getTitle(selectedItem), new RentConfirmationListener(), this).setVisible(true);
            }
        }
    }

    public class RentConfirmationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(model.rentBook(currentUser, theCollection.getTitle(selectedItem))) {
                System.out.println("Item rented: " + selectedItem);
                System.out.println("Rented copies: " + theCollection.getTitle(selectedItem).getRented());
            }
            else {
                System.out.println("Item not rented: " + selectedItem);
                String msg = "Todos os titulos estao alugados!!!";
                JOptionPane.showMessageDialog(new JFrame(), msg, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
