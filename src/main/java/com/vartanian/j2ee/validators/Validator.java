package com.vartanian.j2ee.validators;

import com.vartanian.j2ee.models.CreditCard;

import javax.jws.WebService;

/**
 * Created by super on 11/13/15.
 */
@WebService
public interface Validator {

    boolean validate(CreditCard creditCard);

}