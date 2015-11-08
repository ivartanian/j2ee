package com.vartanian.j2ee.validators;

import com.vartanian.j2ee.restrictions.USA;

/**
 * Created by vartanian on 08.11.2015.
 */
@USA
public class ZipCodeChecker {

    public boolean isZipCodeValid(String zipCode) {
        // Call an external web service to check zipcode
        return true;
    }
}