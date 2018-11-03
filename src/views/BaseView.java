package views;
import javax.swing.*;
import java.awt.*;

public abstract class BaseView extends JFrame {

    protected JPanel topPanel;
    protected JPanel mainPanel;

    public BaseView() {

        JPanel thePanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(360, 400);

        thePanel.setBackground(Color.LIGHT_GRAY);
        thePanel.setLayout(new BorderLayout());

        topPanel = new TopPanel();
        thePanel.add(topPanel, BorderLayout.PAGE_START);

        mainPanel = new MainPanel();
        thePanel.add(mainPanel, BorderLayout.CENTER);

        this.add(thePanel);

    }

}