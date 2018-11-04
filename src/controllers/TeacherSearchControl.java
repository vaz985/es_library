package controllers;

import models.Collection;
import models.Library;
import models.users.User;
import views.BaseView;
import views.TeacherRentDialog;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherSearchControl {
    private Collection theCollection;
    private BaseView theView;

    private String selectedItem;

    private Library model;
    private User currentUser;

    public TeacherSearchControl(Library model, BaseView v, User currentUser) {
        this.model = model;
        this.currentUser = currentUser;

        theCollection = model.getC();
        theView = v;

        theView.drawList(theCollection.getCollectionNames(), new TeacherSearchControl.RentChangeSelectionListener());
        theView.revalidate();
    }

    public class RentChangeSelectionListener implements ListSelectionListener {
        public boolean exist = false;

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if(!listSelectionEvent.getValueIsAdjusting() && !exist) {
                selectedItem = theView.getSelectedItem();
                System.out.println("Item selected: " + selectedItem + Boolean.toString(listSelectionEvent.getValueIsAdjusting()));
                new TeacherRentDialog(theCollection.getTitle(selectedItem), new TeacherSearchControl.RentChangeConfirmationListener(), this).setVisible(true);
            }
        }
    }

    public class RentChangeConfirmationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton sourceButton = (JButton)actionEvent.getSource();
            String source = sourceButton.getText();
            if(source.equals("Alugar")) {
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
            if(source.equals("Modificar")) {
                System.out.println("Item modified: " + selectedItem);
            }
        }
    }
}
