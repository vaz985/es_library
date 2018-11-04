package views;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public abstract class ViewBase extends JFrame {

    protected PanelOptions optionsPanel;

    protected JList<String> list;
    protected JScrollPane scrollPane;

//    protected JTable table;
//    protected JScrollPane pane;

    private static final int DEFAULT_HEIGHT = 360;
    private static final int DEFAULT_WIDTH = 480;

    public ViewBase(String title) {

        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT+40));

        optionsPanel = new PanelOptions();

        add(optionsPanel, BorderLayout.PAGE_START);

    }

    public void drawList(String[] strings, ListSelectionListener selectionListener) {

        list = new JList<>(strings);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(selectionListener);

        scrollPane = new JScrollPane(list);
        scrollPane.setBackground(Color.WHITE);

        add(scrollPane, BorderLayout.CENTER);

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

        return list.getSelectedValue();

    }

}