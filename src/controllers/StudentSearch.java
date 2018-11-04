package controllers;

import models.Collection;
import models.Library;
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

    public StudentSearch(Library model, BaseView v) {

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
                new RentDialog(theCollection.getTitle(selectedItem), new RentConfirmationListener(), this).setVisible(true);
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
