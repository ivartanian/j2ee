package com.vartanian.j2ee.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by vartanian on 08.11.2015.
 */
public class AddressIT {
    @Test
    public void shouldRaiseConstraintViolationCauseInvalidZipCode() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Address address = new Address("233 Стрит", "Нью-Йорк", "NY", "DummyZip", "США");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(1, violations.size());
        vf.close();
    }
}