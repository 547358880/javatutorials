package com.ericaShy.java8.typeinfo;

import javafx.geometry.Pos;

import java.util.Optional;

class EmptyTitleException extends RuntimeException {}

public class Position {
    private String title;
    private Person person;

    Position(String jobTitle, Person employee) {
        setTitle(jobTitle);
        setPerson(employee);
    }

    Position(String jobTitle) {
        this(jobTitle, null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = Optional.ofNullable(newTitle).orElseThrow(EmptyTitleException::new);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person newPerson) {
        person = Optional.ofNullable(newPerson).orElse(new Person());
    }

    @Override
    public String toString() {
        return "Position: " + title + ", Employee: " + person;
    }

    public static void main(String[] args) {
        System.out.println(new Position("CEO"));
        System.out.println(new Position("Programmer", new Person("Arthur", "Fonzarelli")));

        try {
            new Position(null);
        } catch (Exception e) {
            System.out.println("caught " + e);
        }
    }
}
