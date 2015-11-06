package com.vartanian.j2ee.generators.impl;

import com.vartanian.j2ee.annotations.EightDigits;
import com.vartanian.j2ee.annotations.Loggable;
import com.vartanian.j2ee.annotations.ThirteenDigits;
import com.vartanian.j2ee.generators.NumberGenerator;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by super on 11/6/15.
 */
@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {
    @Inject
    private Logger logger;
    @Loggable
    public String generateNumber() {
        String mock = "MOCK-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован Mock : " + mock);
        return mock;
    }
}