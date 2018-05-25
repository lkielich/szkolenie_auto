package com.jsystems.api.models;

public class TestUserGeneric<T> {

    public T id;
    public String name;
    public String surname;

    @Override
    public String toString() {
        return "TestUserGeneric{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
