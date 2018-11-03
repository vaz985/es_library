package views;

public class MainPanel extends JPanel {

    private static final int DEFAULT_WIDTH = 360;

    public MainPanel() {

        super();

        //setBackground(null);
        //setBorder(Util.DEFAULT_BORDER_5);
        setHeight(DEFAULT_HEIGHT);
        setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    }

}
