package ru.otus.spring.dao.problems;

import ru.otus.spring.domain.Problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ProblemsSourceCsv implements ProblemsSourceDao {

    private String path;
    private int position;
    private AtomicInteger total;
    private Random rand;

    public ProblemsSourceCsv(String path) {
        this.path = path;
        this.position = 0;
        this.total = new AtomicInteger(-1);
        this.rand = new Random();
    }

    @Override
    public Optional<Problem> next() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Optional<String> line = reader.lines().skip(position).findFirst();
            position++;
            return line.map(s -> s.split(","))
                    .map(a -> new Problem(a[0], Integer.parseInt(a[1]), Arrays.copyOfRange(a, 2, a.length)));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Problem> random() {
        reset();
        Optional<Problem> result = Optional.empty();
        while (position < rand.nextInt(total())) {
            result = next();
        }
        return result;
    }

    @Override
    public void reset() {
        this.position = 0;
    }

    @Override
    public int total() {
        return total.updateAndGet(cur -> cur < 0 ? countTotal() : cur);
    }

    private int countTotal() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return Math.toIntExact(reader.lines().count());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
