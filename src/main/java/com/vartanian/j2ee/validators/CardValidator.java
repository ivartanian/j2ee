package com.vartanian.j2ee.validators;

import com.vartanian.j2ee.models.CreditCard;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by super on 11/13/15.
 */
@WebService(endpointInterface = "com.vartanian.j2ee.validators.Validator")
public class CardValidator implements Validator{

    @Override
    public boolean validate(CreditCard creditCard) {

        Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);
        if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
            return true;
        } else {
            return false;
        }

    }

}