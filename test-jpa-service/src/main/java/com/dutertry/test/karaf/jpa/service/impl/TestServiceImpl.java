package com.dutertry.test.karaf.jpa.service.impl;

import com.dutertry.test.karaf.jpa.entities.Person;
import com.dutertry.test.karaf.jpa.service.TestService;
import java.util.List;

/**
 *
 * @author ndutertry
 */
public class TestServiceImpl implements TestService {
    private TestRepository testRepository;

    public void setTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void create(Person person) {
        testRepository.create(person);
    }

    @Override
    public List<Person> list() {
        return testRepository.list();
    }
    
    @Override
    public void delete(String... names) {
        testRepository.delete(names);
    }
    
}
