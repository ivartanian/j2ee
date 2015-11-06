package com.vartanian.j2ee;

import com.vartanian.j2ee.models.Book;
import com.vartanian.j2ee.services.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Created by super on 11/6/15.
 */
public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService =
                container.instance().select(BookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Интересная книга на тему высоких технологий");
                System.out.println(book);
        weld.shutdown();
    }
}