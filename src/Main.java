import controllers.*;
import models.Library;
import models.users.*;
import views.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {

        Library L = new Library();
        System.out.println("Nome do usuario: ");
        User u;
        String username = "";
        while ((u = L.getU().getUser(username)) == null) {
            username = (new Scanner(System.in)).next();
        }
        BaseView theView;
        if (u instanceof Teacher) {
            System.out.println("Load Teacher");
            theView = new TeacherView(u);
            theView.setVisible(true);
            new TeacherSearch(L, theView);
        }
        if (u instanceof Student) {
            System.out.println("Load Student");
            theView = new StudentView(u);
            theView.setVisible(true);
            new StudentSearch(L, theView);
        }
    }
}