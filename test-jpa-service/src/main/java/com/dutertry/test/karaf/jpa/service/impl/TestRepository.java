package com.dutertry.test.karaf.jpa.service.impl;

import com.dutertry.test.karaf.jpa.entities.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author ndutertry
 */
public class TestRepository {
    @PersistenceContext(unitName = "test")
    private EntityManager entityManager;

    @Transactional
    public void create(Person person) {
        entityManager.persist(person);
    }

    @Transactional
    public List<Person> list() {
        TypedQuery<Person> query = entityManager.createQuery(
            "select p from Person p order by p.lastName",
            Person.class);
        
        return new ArrayList<>(query.getResultList());
    }
    
    @Transactional
    public void delete(String... names) {
        for (String name : names) {
            Person person = entityManager.find(Person.class, name);
            entityManager.remove(person);
        }
    }
}
