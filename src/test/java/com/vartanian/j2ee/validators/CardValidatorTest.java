package com.vartanian.j2ee.validators;

import com.vartanian.j2ee.models.CreditCard;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by super on 11/13/15.
 */
public class CardValidatorTest {

    @Test
    public void shouldCheckCreditCardValidity() {

        CardValidator cardValidator = new CardValidator();

        CreditCard creditCard = new CreditCard();
        creditCard.setNumber("12341234");
        creditCard.setExpiryDate("10/10");
        creditCard.setControlNumber(1234);
        creditCard.setType("VISA");
        assertTrue("Credit card should be valid", cardValidator.validate(creditCard));

        creditCard.setNumber("12341233");
        assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));

    }
}