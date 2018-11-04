import controllers.*;
import models.Library;
import models.users.*;
import views.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {

        Library L = new Library(argv[0]);
        User u;

        System.out.println("Nome do usuario: ");
        String username = "";

        while ((u = L.getU().getUser(username)) == null) {
            username = (new Scanner(System.in)).next();
        }

        BaseView theView;

        if (u instanceof Teacher) {
            System.out.println("Load Teacher");
            theView = new SearchView((Teacher) u);
            theView.setVisible(true);
            new TeacherSearchControl(L, theView, u);
        }

        if (u instanceof Student) {
            System.out.println("Load Student");
            theView = new SearchView((Student)u);
            theView.setVisible(true);
            new StudentSearchControl(L, theView, u);
        }

        if (u instanceof Administrator) {
            System.out.println("Load Adm");
            theView = new SearchView((Administrator)u);
            theView.setVisible(true);
            new AdminSearchControl(L, theView, u);
        }

    }

}