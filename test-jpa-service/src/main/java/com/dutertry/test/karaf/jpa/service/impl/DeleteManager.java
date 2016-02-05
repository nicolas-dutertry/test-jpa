/*
 * © 1996-2014 Sopra HR Software. All rights reserved
 */
package com.dutertry.test.karaf.jpa.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author ndutertry
 */
public class DeleteManager {
    @PersistenceContext(unitName = "test")
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void delete(String lastName) {
        Query query = entityManager.createQuery(
            "delete from Person where lastName = :lastName");
        
        query.setParameter("lastName", lastName);
        query.executeUpdate();
    }
    
}
