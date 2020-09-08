package ru.test.test82;

public class Person {
    static class Child1 {
        static String hello() {
            return "привет";
        }
    }

    class Child2 {
        String hello() {
            return "servus";
        }
    }

    public void main(String[] args) {
        System.out.println(new Person.Child1().hello());
        System.out.println(new Person.Child2().hello());
    }
}
