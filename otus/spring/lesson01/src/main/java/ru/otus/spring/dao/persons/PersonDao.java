package ru.otus.spring.dao.persons;

import ru.otus.spring.domain.Person;

public interface PersonDao {

    Person getOrCreate(String name);

}
