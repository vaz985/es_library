package controllers;

import models.Collection;
import views.BaseView;
import views.RentDialog;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class StudentSearch {

    private Collection theCollection;
    private BaseView theView;

    private String selectedItem;

    public StudentSearch(Collection c, BaseView v) {

        theCollection = c;
        theView = v;

        theView.drawList(theCollection.getCollectionNames(), new RentSelectionListener());

    }

    public class RentSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if(!listSelectionEvent.getValueIsAdjusting()) {
                selectedItem = theView.getSelectedItem();
                System.out.println("Item selected: " + selectedItem + Boolean.toString(listSelectionEvent.getValueIsAdjusting()));
                new RentDialog(theCollection.getTitle(selectedItem), new RentConfirmationListener()).setVisible(true);
            }
        }
    }

    public class RentConfirmationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Item rented: " + selectedItem);
        }
    }

}
