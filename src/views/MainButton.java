package views;

public class MainButton extends JButton {

    private static final int DEFAULT_HEIGHT = 20;

    public MainButton(String text) {

        super(text);

        //setBorder();
        setContentAreaFilled(false);
        setHeight(DEFAULT_HEIGHT);

    }

}
