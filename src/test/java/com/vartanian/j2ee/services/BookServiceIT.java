package com.vartanian.j2ee.services;

import com.vartanian.j2ee.models.Book;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by super on 11/6/15.
 */
public class BookServiceIT {
    @Test
    public void shouldCheckNumberIsMOCK() {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService =
                container.instance().select(BookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Интересная книга на тему высоких технологий");
        assertTrue(book.getNumber().startsWith("MOCK"));
        weld.shutdown();
    }
}
