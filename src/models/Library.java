package models;
import controllers.StudentSearch;
import models.users.Student;
import models.users.User;
import views.BaseView;
import views.StudentView;

public class Library {
    Collection c = new Collection("/home/artv/Desktop/es_library/livros");
    UserBase   u = new UserBase("/home/artv/Desktop/es_library/usuarios");

    public UserBase getU() {
        return u;
    }

    public Collection getC() {
        return c;
    }

}
