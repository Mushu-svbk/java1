package ru.progwards.java1.lessons.classes;

public class Hamster extends Animal{
    public Hamster(double weight) { // вес животного
        super(weight);
    }

    @Override
    public AnimalKind getKind() { //возвращает вид животного
        return AnimalKind.HAMSTER;
    }

    @Override
    public Animal.FoodKind getFoodKind() { //возвращает вид еды
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {//возвращает коэффициент веса еды к весу тела животного
        switch (getKind()) {
            default:
                return 0.03;
        }
    }
}
