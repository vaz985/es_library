package views;
import javax.swing.*;
import java.awt.*;

public abstract class BaseView extends JPanel {

    private final int minHeight = 400;
    private final int minWidth = 360;

    private JPanel topPanel;
    private JPanel mainPanel;

    public void BaseView() {

        //setBackground(null);
        //setBorder(Util.DEFAULT_BORDER_5);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(minWidth, minHeight));
        setPreferredSize(new Dimension(minWidth, minHeight));

        topPanel = new JPanel();
        //topPanel.setBackground(null);
        //topPanel.setBorder(Util.DEFAULT_BORDER_5);
        topPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 5,5));

        add(topPanel, BorderLayout.PAGE_START);

        mainPanel = new JPanel();
        //mainPanel.setBackground(null);
        //mainPanel.setBorder(Util.DEFAULT_BORDER_5);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        add(mainPanel, BorderLayout.CENTER);

    }

}