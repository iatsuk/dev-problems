package ru.otus.spring.dao.persons;

import ru.otus.spring.domain.Person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PersonInMemory implements PersonDao {

    private Map<String, Person> cache = new ConcurrentHashMap<>();

    @Override
    public Person getOrCreate(String name) {
        return cache.computeIfAbsent(name, Person::new);
    }

}
