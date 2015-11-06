package com.vartanian.j2ee.generators.impl;

import com.vartanian.j2ee.annotations.Loggable;
import com.vartanian.j2ee.annotations.ThirteenDigits;
import com.vartanian.j2ee.generators.NumberGenerator;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by super on 11/6/15.
 */
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;
    @Loggable
    public String generateNumber() {
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISBN : " + isbn);
        return isbn;
    }
}