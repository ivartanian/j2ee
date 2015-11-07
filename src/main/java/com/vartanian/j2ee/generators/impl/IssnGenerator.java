package com.vartanian.j2ee.generators.impl;

import com.vartanian.j2ee.annotations.EightDigits;
import com.vartanian.j2ee.annotations.Loggable;
import com.vartanian.j2ee.generators.NumberGenerator;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by super on 11/6/15.
 */
@EightDigits
public class IssnGenerator implements NumberGenerator{
    @Inject
    private Logger logger;
    @Loggable
    public String generateNumber() {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISBN : " + issn);
        return issn;
    }
}