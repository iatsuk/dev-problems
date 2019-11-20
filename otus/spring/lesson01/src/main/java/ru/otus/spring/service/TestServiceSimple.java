package ru.otus.spring.service;

import ru.otus.spring.dao.persons.PersonDao;
import ru.otus.spring.domain.Person;

public class TestServiceSimple implements TestService {

    private PersonDao dao;

    public TestServiceSimple(PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.getOrCreate(name);
    }

}
