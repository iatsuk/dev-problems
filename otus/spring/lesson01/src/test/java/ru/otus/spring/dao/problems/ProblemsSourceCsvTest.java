package ru.otus.spring.dao.problems;

import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Problem;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProblemsSourceCsvTest {

    @Test
    void next() {
        String path = Objects.requireNonNull(ProblemsSourceCsvTest.class.getClassLoader().getResource("test_problems.csv")).getPath();
        ProblemsSourceDao dao = new ProblemsSourceCsv(path);
        Optional<Problem> problem = dao.next();
        assertTrue(problem.isPresent());
        assertEquals("Zero", problem.get().getQuestion());
        assertEquals("0", problem.get().getRightAnswer());
        assertArrayEquals(new String[]{"0", "1", "2", "3", "4"}, problem.get().getAnswers());

        problem = dao.next();
        assertTrue(problem.isPresent());
        assertEquals("One", problem.get().getQuestion());
        assertEquals("1", problem.get().getRightAnswer());
        assertArrayEquals(new String[]{"0", "1", "2", "3", "4"}, problem.get().getAnswers());

        problem = dao.next();
        assertFalse(problem.isPresent());
    }

    @Test
    void reset() {
        String path = Objects.requireNonNull(ProblemsSourceCsvTest.class.getClassLoader().getResource("test_problems.csv")).getPath();
        ProblemsSourceDao dao = new ProblemsSourceCsv(path);
        Optional<Problem> problem = dao.next();
        assertTrue(problem.isPresent());
        assertEquals("Zero", problem.get().getQuestion());
        assertEquals("0", problem.get().getRightAnswer());
        assertArrayEquals(new String[]{"0", "1", "2", "3", "4"}, problem.get().getAnswers());

        dao.reset();
        problem = dao.next();
        assertTrue(problem.isPresent());
        assertEquals("Zero", problem.get().getQuestion());
        assertEquals("0", problem.get().getRightAnswer());
        assertArrayEquals(new String[]{"0", "1", "2", "3", "4"}, problem.get().getAnswers());
    }

    @Test
    void total() {
        String path = Objects.requireNonNull(ProblemsSourceCsvTest.class.getClassLoader().getResource("test_problems.csv")).getPath();
        ProblemsSourceDao dao = new ProblemsSourceCsv(path);
        assertEquals(2, dao.total());
    }

}