package ru.progwards.java1.lessons.interfaces;

import static ru.progwards.java1.lessons.interfaces.Animal.AnimalKind.DUCK;

public class Duck extends Animal {

    public Duck(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return DUCK;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.04;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public static void main(String[] args) {
        Duck animal = new Duck(3);
        System.out.println(animal);
    }

}
