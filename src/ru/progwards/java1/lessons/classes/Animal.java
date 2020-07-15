package ru.progwards.java1.lessons.classes;

public class Animal {
    double weight;

    public Animal(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return this.weight;
    }

    enum AnimalKind {
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    enum FoodKind {
        UNKNOWN,
        HAY,
        CORN
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }


    public String toString() {
        return ("I am " + this.getKind() + ", eat " + this.getFoodKind());
    }

    public double getFoodCoeff() {
        switch (getKind()) {
            default:
                return 0.02;
        }
    }

    public double calculateFoodWeight() {
        return this.getWeight() * this.getFoodCoeff();
    }

    public String toStringFull() {
        return ("I am " + this.getKind() + ", eat " + this.getFoodKind() + " " + this.calculateFoodWeight());
    }

    public static void printInfo(Animal animal) {
        System.out.println(animal);
    }

    public static void main(String[] args) {
        Animal animal = new Animal(0);
        Cow cow = new Cow (35);
        Hamster hamster = new Hamster(62);
        Duck duck = new Duck(4.5);

        printInfo(animal);
        printInfo(cow);
        printInfo(hamster);
        printInfo(duck);

        System.out.println(" ");
        System.out.println(animal.toStringFull());
        System.out.println(cow.toStringFull());
        System.out.println(hamster.toStringFull());
        System.out.println(duck.toStringFull());
    }
}
