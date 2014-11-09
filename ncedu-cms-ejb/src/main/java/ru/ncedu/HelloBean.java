package ru.ncedu;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class HelloBean {

    public String sayHello() {
        return "Hello";
    }

}
