package ru.otus.spring.domain;

public class Problem {

    private String question;
    private int rightAnswer;
    private String[] answers;

    public Problem(String question, int rightAnswer, String... answers) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public String getRightAnswer() {
        return answers[rightAnswer];
    }

    public String[] getAnswers() {
        return answers;
    }
}
