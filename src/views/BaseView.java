package views;
import javax.swing.*;
import java.awt.*;

public abstract class BaseView extends JPanel {

    private JPanel topPanel;
    private JPanel mainPanel;

    public void BaseView() {

        //setBackground(null);
        //setBorder(Util.DEFAULT_BORDER_5);
        setLayout(new BorderLayout());

        topPanel = new TopPanel();
        add(topPanel, BorderLayout.PAGE_START);

        mainPanel = new MainPanel();
        add(mainPanel, BorderLayout.CENTER);

    }

}