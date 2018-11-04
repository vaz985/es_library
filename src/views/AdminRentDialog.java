package views;

import controllers.AdminSearchControl;
import models.titles.Title;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminRentDialog extends RentDialogView {

    protected JButton rentButton;
    protected JButton changeButton;

    public AdminRentDialog(Title theTitle, ActionListener rentListener, AdminSearchControl.RentChangeSelectionListener rentSelectionListener) {

        super(theTitle);

        rentSelectionListener.exist = true;

        rentButton = new JButton("Alugar");
        rentButton.addActionListener(rentListener);
        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rentSelectionListener.exist = false;
                theFrame.dispose();
            }
        });

        changeButton = new JButton("Modificar");
        changeButton.addActionListener(rentListener);
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rentSelectionListener.exist = false;
                theFrame.dispose();
            }
        });

        optionsPanel.add(rentButton);
        optionsPanel.add(changeButton);

        thePanel.add(mainPanel, BorderLayout.CENTER);
        thePanel.add(optionsPanel, BorderLayout.PAGE_END);

        this.add(thePanel);

        // Remove flag after closing window
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                rentSelectionListener.exist = false;
            }
        });

    }

}
