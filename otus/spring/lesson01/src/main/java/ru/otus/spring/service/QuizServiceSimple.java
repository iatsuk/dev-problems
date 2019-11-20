package ru.otus.spring.service;

import ru.otus.spring.dao.persons.UserDao;
import ru.otus.spring.dao.problems.ProblemsSourceDao;
import ru.otus.spring.domain.Person;
import ru.otus.spring.domain.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Scanner;

public class QuizServiceSimple implements QuizService {

    private UserDao users;
    private ProblemsSourceDao problems;

    public QuizServiceSimple(UserDao users, ProblemsSourceDao problems) {
        this.users = users;
        this.problems = problems;
    }

    @Override
    public void run() {
        Person person = registerUser();
        int rating = quizUser(person);
        System.out.println(String.format("Рейтинг пользователя %d балл(a,ов)", rating));
    }

    private Person registerUser() {
        System.out.println("Введите ваше имя:");
        Scanner scanner = new Scanner(System.in);
        return users.getOrCreate(scanner.nextLine());

    }

    private int quizUser(Person person) {
        int right = 0;
        for (int i = 0; i < Math.min(5, problems.total()); i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Optional<Problem> problem = problems.next();
            if (problem.isPresent()) {
                try {
                    printQuestion(problem.get());
                    int userAnswer = Integer.parseInt(reader.readLine());
                    if (problem.get().getRightAnswer().equals(problem.get().getAnswers()[userAnswer])) {
                        right++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("WARN\tproblem is not exists");
            }
        }
        person.setRating(right);
        return right;
    }

    private void printQuestion(Problem problem) {
        System.out.println(problem.getQuestion());
        for (int j = 0; j < problem.getAnswers().length; j++) {
            System.out.println(j + ". " + problem.getAnswers()[j]);
        }
    }

}
