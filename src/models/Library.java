package models;
import models.titles.Title;
import models.users.User;

public class Library {

    private Collection c;
    private UserBase   u;

    public Library(String path) {

        c = new Collection(path + "livros");
        u = new UserBase(path + "usuarios");

    }

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
