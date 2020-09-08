package ru.test.test82;

public class Dog implements Speaking, Eating{
    @Override
    public String eat() {
        return "Мясо";
    }

    @Override
    public String say() {
        return "Гав";
    }
}
