package ru.otus.spring.dao.problems;

import ru.otus.spring.domain.Problem;

import java.util.Optional;

public interface ProblemsSourceDao {

    Optional<Problem> next();

    Optional<Problem> random();

    void reset();

    int total();
}
