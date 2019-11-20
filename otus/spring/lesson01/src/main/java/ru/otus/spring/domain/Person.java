package ru.otus.spring.domain;

public class Person {

    private String name;
    private int rating;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
