package ru.progwards.java1.lessons.interfaces;

import java.util.Objects;

import static ru.progwards.java1.lessons.interfaces.Animal.FoodKind.UNKNOWN;

public class Animal implements FoodCompare, CompareWeight {

    enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}
    enum FoodKind {UNKNOWN, HAY, CORN}

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return UNKNOWN;
    }

    private final double weight; // вес животного

    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject == this) return true;
        if (anObject == null || anObject.getClass() != this.getClass()) return false;
        Animal o = (Animal) anObject;
        return Double.compare(o.calculateFoodWeight(), this.calculateFoodWeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    public Animal(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareFoodPrice(Animal animal) {
        return Double.compare(this.getFoodPrice(), animal.getFoodPrice());
    }

    public double getFood1kgPrice() {
        switch (getFoodKind()) {
            case UNKNOWN:
                break;
            case HAY: return 20d;
            case CORN: return 50d;
        }
        return 0d;
    }

    @Override
    public String toString() {
        return "I am" + " " + getKind() + "," + " " + "eat" + " " + getFoodKind() + " " + calculateFoodWeight() + " gr";
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return 0.02;
    }

    public double calculateFoodWeight() {
        return getWeight() * getFoodCoeff();
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Animal otherAnimal = (Animal) smthHasWeigt;
        int doubcom = Double.compare(this.getWeight(), otherAnimal.getWeight());
        return switch (doubcom) {
            case (-1) -> CompareResult.LESS;
            case (0) -> CompareResult.EQUAL;
            default -> CompareResult.GREATER;
        };
    }

    public static void main(String[] args) {
        Animal animal = new Animal(0.0);
        Cow cow = new Cow(190.0);
        Duck duck = new Duck(0.2);
        Hamster hamster = new Hamster(3.5);
        System.out.println(animal);
        System.out.println(cow);
        System.out.println(duck);
        System.out.println(hamster);
        Cow mu = new Cow(500);
        Duck kra = new Duck(7);
        Hamster meat = new Hamster(10);
        System.out.println(mu.compareWeight(meat));
        System.out.println(mu.compareWeight(kra));
        System.out.println(kra.compareWeight(meat));
        System.out.println(cow.compareFoodPrice(hamster));
        System.out.println(duck.compareFoodPrice(cow));
        System.out.println(hamster.compareFoodPrice(duck));
    }
}
