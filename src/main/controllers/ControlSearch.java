package controllers;

import models.Collection;
import models.Library;
import users.User;
import views.ViewBase;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ControlSearch {

    protected Library library;
    protected User user;

    protected Collection collection;
    protected ViewBase view;

    protected String selectedItem;

    public ControlSearch(Library library, ViewBase view, User user) {

        this.library = library;
        this.user = user;

        this.collection = library.getC();
        this.view = view;

    }

    public class RentSelectionListener implements ListSelectionListener {

        protected boolean exists = false;

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if(!listSelectionEvent.getValueIsAdjusting() && !exists) {
                selectedItem = view.getSelectedItem();
                System.out.println("Item selected: " + selectedItem + Boolean.toString(listSelectionEvent.getValueIsAdjusting()));
                openDialog();
            }
        }

        public void setExists(Boolean b) {
            exists = b;
        }

        public void openDialog() {};

    }

    public class RentDialogListener implements ActionListener {

        protected JButton sourceButton;
        protected String source;

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            sourceButton = (JButton) actionEvent.getSource();
            source = sourceButton.getText();

            performActions();

        }

        public void performActions() {

            if (source.equals("Alugar")) {
                rent();
            }

        }

        public void rent() {

            if(library.rentBook(user, collection.getTitle(selectedItem))) {
                System.out.println("Item rented: " + selectedItem);
                System.out.println("Rented copies: " + collection.getTitle(selectedItem).getRented());
            }
            else {
                System.out.println("Item not rented: " + selectedItem);
                String msg = "All copies are rented!!!";
                JOptionPane.showMessageDialog(new JFrame(), msg, "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        public void modify() {
            System.out.println("Item modified: " + selectedItem);
        }

    }

}