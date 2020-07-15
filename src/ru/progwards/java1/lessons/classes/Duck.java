package ru.progwards.java1.lessons.classes;

public class Duck extends Animal{
    public Duck(double weight) { // вес животного
        super(weight);
    }

    @Override
    public AnimalKind getKind() { //возвращает вид животного
        return AnimalKind.DUCK;
    }

    @Override
    public Animal.FoodKind getFoodKind() { //возвращает вид еды
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() { //возвращает коэффициент веса еды к весу тела животного
        switch (getKind()) {
            default:
                return 0.04;
        }
    }
}
