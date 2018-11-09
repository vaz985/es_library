package models;

import titles.Title;

import users.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void rentBook() {
        User u = new User("nome", 0);
        UserBase ub = new UserBase();
        ub.addUser(u);
        Title t = new Title("livro", "autor", 1, 1);
        Collection c = new Collection();
        c.addTitle(t);
        Library l = new Library(c, ub);
        assertTrue(l.rentBook(u, t));
    }
}