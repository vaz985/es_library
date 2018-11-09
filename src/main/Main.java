import controllers.*;
import models.Library;
import users.*;
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

        ViewBase theView;

        if (u instanceof Teacher) {
            System.out.println("Load Teacher");
            theView = new ViewSearch((Teacher) u);
            theView.setVisible(true);
            new ControlSearchTeacher(L, theView, u);
        }

        if (u instanceof Student) {
            System.out.println("Load Student");
            theView = new ViewSearch((Student)u);
            theView.setVisible(true);
            new ControlSearchStudent(L, theView, u);
        }

        if (u instanceof Administrator) {
            System.out.println("Load Adm");
            theView = new ViewSearch((Administrator)u);
            theView.setVisible(true);
            new ControlSearchAdmin(L, theView, u);
        }

    }

}