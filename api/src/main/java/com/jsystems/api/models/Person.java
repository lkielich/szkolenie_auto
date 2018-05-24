package com.jsystems.api.models;

public class Person {
    public String name;
    public String surname;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
