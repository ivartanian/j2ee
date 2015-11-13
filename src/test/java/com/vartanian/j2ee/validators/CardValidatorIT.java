package com.vartanian.j2ee.validators;

import com.vartanian.j2ee.models.CreditCard;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by super on 11/13/15.
 */
public class CardValidatorIT {

    @Test
    public void shouldCheckCreditCardValidity() throws MalformedURLException {

        // Publishes the SOAP Web Service
        Endpoint endpoint = Endpoint.publish("http://localhost:8888/cardValidator", new CardValidator());
        assertTrue(endpoint.isPublished());
        assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());

        // Needed properties to access the web service
        URL wsdlDocumentLocation = new URL("http://localhost:8888/cardValidator?wsdl");
        String namespaceURI = "http://validators.j2ee.vartanian.com/";
        String servicePart = "CardValidatorService";
        String portName = "CardValidatorPort";
        QName serviceQN = new QName(namespaceURI, servicePart);
        QName portQN = new QName(namespaceURI, portName);

        // Creates a service instance
        Service service = Service.create(wsdlDocumentLocation, serviceQN);
        Validator cardValidator = service.getPort(portQN, Validator.class);

        // Invokes the web service
        CreditCard creditCard = new CreditCard();
        creditCard.setNumber("12341234");
        creditCard.setExpiryDate("10/10");
        creditCard.setControlNumber(1234);
        creditCard.setType("VISA");

        assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));

        creditCard.setNumber("12341233");
        assertTrue("Credit card should be valid", cardValidator.validate(creditCard));

        // Unpublishes the SOAP Web Service
        endpoint.stop();
        assertFalse(endpoint.isPublished());

    }
}