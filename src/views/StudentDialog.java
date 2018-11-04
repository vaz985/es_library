package views;

import controllers.StudentSearch;
import models.titles.Title;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentDialog extends JFrame {

    public JPanel mainPanel;
    public JButton rentButton;
    public JFrame theFrame;

    private static final int DEFAULT_HEIGHT = 180;
    private static final int DEFAULT_WIDTH = 240;

    public StudentDialog(Title theTitle, ActionListener rentListener, StudentSearch.RentSelectionListener rentSelectionListener) {
        rentSelectionListener.exist = true;

        theFrame = this;
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        JPanel thePanel = new JPanel();

        thePanel.setBackground(Color.LIGHT_GRAY);
        thePanel.setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6,2));
        mainPanel.add(new JTextArea("Título:"));
        mainPanel.add(new JTextArea(theTitle.getTitle_name()));
        mainPanel.add(new JTextArea("Autor:"));
        mainPanel.add(new JTextArea(theTitle.getAuthor()));
        mainPanel.add(new JTextArea("Ano:"));
        mainPanel.add(new JTextArea(Integer.toString(theTitle.getYear())));
        mainPanel.add(new JTextArea("Exemplares:"));
        mainPanel.add(new JTextArea(Integer.toString(theTitle.getQuantity())));
        mainPanel.add(new JTextArea("Alugados:"));
        mainPanel.add(new JTextArea(Integer.toString(theTitle.getRented())));
        mainPanel.add(new JTextArea("Tempo máximo:"));
        mainPanel.add(new JTextArea(Integer.toString(theTitle.getMax_allowance_time()) + " dias"));

        rentButton = new JButton("Alugar");
        rentButton.addActionListener(rentListener);
        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rentSelectionListener.exist = false;
                theFrame.dispose();
            }
        });


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