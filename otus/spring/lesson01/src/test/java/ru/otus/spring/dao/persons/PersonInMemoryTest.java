package ru.otus.spring.dao.persons;

import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonInMemoryTest {

    @Test
    void getTest() {
        PersonDao dao = new PersonInMemory();
        Person person = dao.getOrCreate("Andrei");
        assertNotNull(person);
        assertEquals("Andrei", person.getName());
        assertEquals(0, person.getRating());
    }

    @Test
    void getSameTest() {
        PersonDao dao = new PersonInMemory();
        dao.getOrCreate("Andrei").setRating(5);

        Person person = dao.getOrCreate("Andrei");
        assertNotNull(person);
        assertEquals("Andrei", person.getName());
        assertEquals(5, person.getRating());
    }
}