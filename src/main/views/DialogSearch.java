package views;

import controllers.ControlSearch;
import models.titles.Title;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class DialogSearch extends JFrame {

    protected JFrame frame;
    protected JPanel panel;

    protected JPanel mainPanel;
    protected JPanel optionsPanel;

    protected JButton rentButton;

    private static final int DEFAULT_HEIGHT = 180;
    private static final int DEFAULT_WIDTH = 240;

    public DialogSearch(Title theTitle, ControlSearch.RentSelectionListener rentSelectionListener, ControlSearch.RentDialogListener rentDialogListener) {

        rentSelectionListener.setExists(true);

        frame = this;
        frame.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 2));
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

        panel.add(mainPanel, BorderLayout.CENTER);

        optionsPanel = new PanelOptions();

        rentButton = new JButton("Alugar");
        rentButton.addActionListener(rentDialogListener);
        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rentSelectionListener.setExists(false);
                frame.dispose();
            }
        });

        optionsPanel.add(rentButton);

    }

}
