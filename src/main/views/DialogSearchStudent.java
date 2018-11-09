package views;

import controllers.ControlSearch;
import controllers.ControlSearchStudent;
import titles.Title;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogSearchStudent extends DialogSearch {

    public DialogSearchStudent(Title theTitle, ControlSearchStudent.RentSelectionListener rentSelectionListener, ControlSearch.RentDialogListener rentDialogListener) {

        super(theTitle, rentSelectionListener, rentDialogListener);

        panel.add(optionsPanel, BorderLayout.PAGE_END);

        frame.add(panel);

        // Remove flag after closing window
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                rentSelectionListener.setExists(false);
            }
        });

    }

}
