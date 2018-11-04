package views;

import controllers.AdminSearchControl;
import models.titles.Title;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class RentDialogView extends JFrame {

    protected JFrame theFrame;
    protected JPanel thePanel;

    protected JPanel mainPanel;
    protected JPanel optionsPanel;

    private static final int DEFAULT_HEIGHT = 180;
    private static final int DEFAULT_WIDTH = 240;

    public RentDialogView(Title theTitle) {

        theFrame = this;
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        thePanel = new JPanel();

        thePanel.setBackground(Color.LIGHT_GRAY);
        thePanel.setLayout(new BorderLayout());

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

        optionsPanel = new OptionsPanel();

    }

}
