package ru.progwards.java1.lessons.classes;

public class Cow extends Animal{
    public Cow(double weight) { // вес животного
        super(weight);
    }

    @Override
    public AnimalKind getKind() { //возвращает вид животного
        return AnimalKind.COW;
    }

    @Override
    public Animal.FoodKind getFoodKind() { //возвращает вид еды
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff() { //возвращает коэффициент веса еды к весу тела животного
        getKind(); {
            return 0.05;
        }
    }
}
