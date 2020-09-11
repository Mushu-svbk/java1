package ru.progwards.java1.lessons.interfaces;

import static ru.progwards.java1.lessons.interfaces.Animal.AnimalKind.COW;

public class Cow extends Animal {

    public Cow(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return COW;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff() {
        return 0.05;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Cow animal = new Cow(250);
        System.out.println(animal);
        System.out.println(animal.getFoodCoeff());
    }

}
