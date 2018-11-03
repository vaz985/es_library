package views;

public class StudentView extends BaseView {

    private TopButton searchButton;
    private TopButton rentedButton;


    public StudentView {

        super();

        searchButton = new TopButton("Search");
        rentedButton = new TopButton("Rented");

        topPanel.add(searchButton);
        topPanel.add(rentedButton);

    }

}