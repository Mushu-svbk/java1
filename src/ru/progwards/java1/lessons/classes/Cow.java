package ru.progwards.java1.lessons.classes;

public class Cow extends Animal{
    public Cow(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.COW;
    }

    @Override
    public Animal.FoodKind getFoodKind() {
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff() {
        switch (getKind()) {
            default:
                return 0.05;
        }
    }
}
