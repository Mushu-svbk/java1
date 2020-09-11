package ru.progwards.java1.lessons.interfaces;

import static ru.progwards.java1.lessons.interfaces.Animal.AnimalKind.HAMSTER;

public class Hamster extends Animal {

    public Hamster(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return HAMSTER;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.03;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Hamster animal = new Hamster(5);
        System.out.println(animal);
    }

}
