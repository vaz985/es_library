package views;

import controllers.ControlSearch;
import titles.Title;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogSearchAdmin extends DialogSearch {

    protected JButton changeButton;

    public DialogSearchAdmin(Title theTitle, ControlSearch.RentSelectionListener rentSelectionListener, ControlSearch.RentDialogListener rentDialogListener) {

        super(theTitle, rentSelectionListener, rentDialogListener);

        changeButton = new JButton("Modificar");
        changeButton.addActionListener(rentDialogListener);
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rentSelectionListener.setExists(false);
                frame.dispose();
            }
        });

        optionsPanel.add(changeButton);

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
