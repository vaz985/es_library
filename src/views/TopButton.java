package views;

public class TopButton extends JButton {

    private static final int DEFAULT_HEIGHT = 30;

    public TopButton(String text) {

        super(text);

        //setBackground(null);
        //setBorder(Util.DEFAULT_BORDER_5);
        setContentAreaFilled(false);
        setHeight(DEFAULT_HEIGHT);

    }

}
