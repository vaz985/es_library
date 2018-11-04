package views;

import models.titles.Title;
import models.users.User;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseView extends JFrame {

    protected TopPanel topPanel;

    private JList<String> theList;
    private JScrollPane theScrollPane;

//    private JTable table;
//    private JScrollPane pane;

    private static final int DEFAULT_HEIGHT = 360;
    private static final int DEFAULT_WIDTH = 480;

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

//    TODO: Table instead of list
//    public void drawList_(ArrayList<Title> list, ListSelectionListener selectionListener) {
//        String[] cols = new String[] {"Nome", "Autor", "Ano", "Quantidade", "Alugados"};
//        String[][] data = new String[list.size()][5];
//        ArrayList<Title> title_list = new ArrayList<Title>(list);
//
//        for(int i=0; i<list.size(); i++) {
//            data[i][0] = title_list.get(i).getTitle_name();
//            data[i][1] = title_list.get(i).getAuthor();
//            data[i][2] = Integer.toString(title_list.get(i).getYear());
//            data[i][3] = Integer.toString(title_list.get(i).getQuantity());
//            data[i][4] = Integer.toString(title_list.get(i).getRented());
//        }
//
//        table = new JTable(data ,cols);
//        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        table.setRowSelectionAllowed(true);
//        table.setCellSelectionEnabled(false);
//        table.setColumnSelectionAllowed(false);
//
//        //table.addListSelectionListener(selectionListener);
//        pane = new JScrollPane(table);
//        pane.setBackground(Color.WHITE);
//
//        this.add(pane, BorderLayout.CENTER);
//
//    }

    public String getSelectedItem() {

        return theList.getSelectedValue();

    }

}