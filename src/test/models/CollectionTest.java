package models;

import users.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import titles.Title;

class CollectionTest {

    @Test
    void avaliableTitle() {
        Collection c = new Collection();
        Title t = new Title("livro1", "autor1", 2000, 1);
        c.addTitle(t);
        assertTrue(c.avaliableTitle(t));
        t.increseRented();
        assertFalse(c.avaliableTitle(t));
    }

    @Test
    void addTitle() {
        Collection c = new Collection();
        Title t0 = new Title("livro0", "autor0", 2000, 1);
        Title t1 = new Title("livro1", "autor1", 2000, 1);
        c.addTitle(t0);
        assertTrue(c.getDatabase().containsValue(t0));
        assertFalse(c.getDatabase().containsValue(t1));
    }

    @Test
    void removeTitle() {
        Collection c = new Collection();
        Title t0 = new Title("livro0", "autor0", 2000, 1);
        c.addTitle(t0);
        assertTrue(c.getDatabase().containsValue(t0));
        c.removeTitle(t0.getTitle_name());
        assertFalse(c.getDatabase().containsValue(t0));
    }

    @Test
    void getTitle() {
        Collection c = new Collection();
        Title t0 = new Title("livro0", "autor0", 2000, 1);
        Title t1 = new Title("livro1", "autor1", 2000, 1);
        c.addTitle(t0);
        assertEquals(t0, c.getTitle(t0.getTitle_name()));
        assertEquals(null, c.getTitle(t1.getTitle_name()));
    }

}