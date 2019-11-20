package ru.otus.spring.service;

import ru.otus.spring.dao.PersonDao;
import ru.otus.spring.domain.Person;

public class PersonServiceSimple implements PersonService {

    private PersonDao dao;

    public PersonServiceSimple(PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
