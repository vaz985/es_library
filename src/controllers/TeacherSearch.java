package controllers;

import models.Collection;
import views.BaseView;
import views.RentChangeDialog;
import views.RentDialog;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherSearch {
    private Collection theCollection;
    private BaseView theView;

    private String selectedItem;

    public TeacherSearch(Collection c, BaseView v) {

        theCollection = c;
        theView = v;

        theView.drawList(theCollection.getCollectionNames(), new TeacherSearch.RentChangeSelectionListener());
        theView.revalidate();
    }

    public class RentChangeSelectionListener implements ListSelectionListener {
        public boolean exist = false;

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if(!listSelectionEvent.getValueIsAdjusting() && !exist) {
                selectedItem = theView.getSelectedItem();
                System.out.println("Item selected: " + selectedItem + Boolean.toString(listSelectionEvent.getValueIsAdjusting()));
                new RentChangeDialog(theCollection.getTitle(selectedItem), new TeacherSearch.RentChangeConfirmationListener(), this).setVisible(true);
            }
        }
    }

    public class RentChangeConfirmationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton sourceButton = (JButton)actionEvent.getSource();
            String source = sourceButton.getText();
            if(source.equals("Alugar")) {
                System.out.println("Item rented: " + selectedItem);
            }
            if(source.equals("Modificar")) {
                System.out.println("Item modified: " + selectedItem);
            }
        }
    }
}
