package ru.otus.spring.dao.persons;

import ru.otus.spring.domain.Person;

public interface UserDao {

    Person getOrCreate(String name);

}
