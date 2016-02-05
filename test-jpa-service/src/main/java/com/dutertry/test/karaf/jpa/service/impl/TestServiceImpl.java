/*
 * © 1996-2014 Sopra HR Software. All rights reserved
 */
package com.dutertry.test.karaf.jpa.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dutertry.test.karaf.jpa.entities.Person;
import com.dutertry.test.karaf.jpa.service.TestService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author ndutertry
 */
public class TestServiceImpl implements TestService {
    @PersistenceContext(unitName = "test")
    private EntityManager entityManager;
    
    private DeleteManager deleteManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setDeleteManager(DeleteManager deleteManager) {
        this.deleteManager = deleteManager;
    }

    @Override
    @Transactional
    public void create(Person person) {
        entityManager.persist(person);
    }

    @Override
    @Transactional
    public List<Person> list() {
        TypedQuery<Person> query = entityManager.createQuery(
            "select p from Person p order by p.lastName",
            Person.class);
        
        return new ArrayList<>(query.getResultList());
    }
    
    @Override
    public void delete(String... names) {
        for (String name : names) {
            System.out.println("Deleting " + name);
            deleteManager.delete(name);
        }
    }
    
}
