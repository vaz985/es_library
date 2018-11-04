package views;

import controllers.StudentSearchControl;
import models.titles.Title;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentRentDialog extends RentDialogView {

    public JButton rentButton;

    public StudentRentDialog(Title theTitle, ActionListener rentListener, StudentSearchControl.RentSelectionListener rentSelectionListener) {

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

        optionsPanel.add(rentButton);

        thePanel.add(mainPanel, BorderLayout.CENTER);
        thePanel.add(rentButton, BorderLayout.PAGE_END);

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
