package views;

import models.users.User;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public abstract class BaseView extends JFrame {

    protected TopPanel topPanel;

    private JList<String> theList;
    private JScrollPane theScrollPane;

    private static final int DEFAULT_HEIGHT = 360;
    private static final int DEFAULT_WIDTH = 360;

    public BaseView(String title) {

        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT+40));

        topPanel = new TopPanel();

        this.add(topPanel, BorderLayout.PAGE_START);

    }

    public void drawList(String[] list, ListSelectionListener selectionListener) {

        theList = new JList<>(list);
        theList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        theList.addListSelectionListener(selectionListener);

        theScrollPane = new JScrollPane(theList);
        theScrollPane.setBackground(Color.WHITE);

        this.add(theScrollPane, BorderLayout.CENTER);

    }

    public String getSelectedItem() {

        return theList.getSelectedValue();

    }

}