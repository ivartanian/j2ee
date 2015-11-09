package com.vartanian.j2ee.validators;

import com.vartanian.j2ee.restrictions.USA;
import com.vartanian.j2ee.restrictions.ZipCode;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vartanian on 08.11.2015.
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
    @Inject
    @USA
    private ZipCodeChecker checker;
    private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

    public void initialize(ZipCode zipCode) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        Matcher m = zipPattern.matcher(value);
        if (!m.matches()) return false;
        return checker.isZipCodeValid(value);
    }
}
