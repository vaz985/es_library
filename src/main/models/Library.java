package models;
import models.titles.Title;
import models.users.User;

public class Library {

    private Collection c;
    private UserBase   u;

    public Library(Collection c, UserBase u) {
        this.c = c;
        this.u = u;
    }

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
        if(this.c.avaliableTitle(t) && this.u.getUser(u.getName()) != null) {
            System.out.println("Pode alugar");
            this.c.rentTitle(u, t);
            return true;
        }
        return false;
    }

}
