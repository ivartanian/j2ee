package com.vartanian.j2ee.services;

import com.vartanian.j2ee.annotations.Loggable;
import com.vartanian.j2ee.annotations.ThirteenDigits;
import com.vartanian.j2ee.generators.NumberGenerator;
import com.vartanian.j2ee.models.Book;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by super on 11/6/15.
 */
@Loggable
public class BookService {
    @Inject @ThirteenDigits
    private NumberGenerator numberGenerator;
    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }
}