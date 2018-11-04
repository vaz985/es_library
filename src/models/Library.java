package models;
import models.titles.Title;
import models.users.User;

public class Library {
    Collection c = new Collection("/home/artv/Desktop/es_library/livros");
    UserBase   u = new UserBase("/home/artv/Desktop/es_library/usuarios");

    public UserBase getU() {
        return u;
    }

    public Collection getC() {
        return c;
    }

    public boolean rentBook(User u, Title t) {
        if(c.avaliableTitle(t)) {
            System.out.println("Pode alugar");
            c.rentTitle(u, t);
            return true;
        }
        return false;
    }

}
