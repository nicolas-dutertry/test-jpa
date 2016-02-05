/*
 * © 1996-2014 Sopra HR Software. All rights reserved
 */
package com.dutertry.test.karaf.jpa.service;

import com.dutertry.test.karaf.jpa.entities.Person;
import java.util.List;

/**
 *
 * @author ndutertry
 */
public interface TestService {    
    List<Person> list();
    void create(Person person);
    void delete(String... names);
}
