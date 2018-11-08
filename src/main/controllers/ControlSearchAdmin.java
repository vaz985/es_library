package controllers;

import models.Library;
import models.users.User;
import views.DialogSearchAdmin;
import views.ViewBase;

public class ControlSearchAdmin extends ControlSearch {

    public ControlSearchAdmin(Library library, ViewBase view, User user) {

        super(library, view, user);

        this.view.drawList(collection.getCollectionNames(), new RentSelectionListener());
        this.view.revalidate();

    }

    public class RentSelectionListener extends ControlSearch.RentSelectionListener {

        @Override
        public void openDialog() {
            new DialogSearchAdmin(collection.getTitle(selectedItem), this, new RentDialogListener()).setVisible(true);
        }

    }

    public class RentDialogListener extends ControlSearch.RentDialogListener {

        @Override
        public void performActions() {

            if (source.equals("Alugar")) {
                rent();
            } else if (source.equals("Modificar")) {
                modify();
            }

        }

        public void modify() {
            System.out.println("Item modified: " + selectedItem);
        }

    }

}
