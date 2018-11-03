package views;

public class TopPanel extends JPanel {

    private static final int DEFAULT_HEIGHT = 40;

    public TopPanel() {

        super();

        //setBackground(null);
        //setBorder(Util.DEFAULT_BORDER_5);
        setHeight(DEFAULT_HEIGHT);
        setLayout(new FlowLayout(FlowLayout.TRAILING, 5,5))

    }

}
