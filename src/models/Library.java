package models;
import controllers.StudentSearch;
import models.users.Student;
import views.BaseView;
import views.StudentView;

public class Library {

    public static void main(String[] argv) {

        Collection c = new Collection("/home/lucas/GitHub/es_library/src/models/livros");

        Student s = new Student("Lucas", 21);

        BaseView theView = new StudentView(s);
        theView.setVisible(true);

        new StudentSearch(c, theView);

    }
}
