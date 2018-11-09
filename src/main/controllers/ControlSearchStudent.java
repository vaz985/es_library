package controllers;

import models.Library;
import users.User;
import views.ViewBase;
import views.DialogSearchStudent;

public class ControlSearchStudent extends ControlSearch {

    public ControlSearchStudent(Library library, ViewBase view, User user) {

        super(library, view, user);

        this.view.drawList(collection.getCollectionNames(), new RentSelectionListener());
        this.view.revalidate();

    }

    public class RentSelectionListener extends ControlSearch.RentSelectionListener {

        @Override
        public void openDialog() {
            new DialogSearchStudent(collection.getTitle(selectedItem), this, new RentDialogListener()).setVisible(true);
        }

    }

}
