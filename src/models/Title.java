package models;

public class Title {
    private String title_name;
    private String author;
    private int year;
    private int quantity;
    private int max_allowance_time;

    public Title(String title_name, String author, int year, int quantity, int max_allowance_time) {
        this.title_name = title_name;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
        this.max_allowance_time = max_allowance_time;
    }

    public int getMax_allowance_time() {
        return max_allowance_time;
    }

    public void setMax_allowance_time(int max_allowance_time) {
        this.max_allowance_time = max_allowance_time;
    }

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}