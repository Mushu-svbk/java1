package ru.progwards.java1.lessons.classes;

public class Animal {
    double weight;

    public Animal(double weight) { // вес животного
        this.weight = weight;
    }
    public double getWeight() { //возвращает вес животного
        return this.weight;
    }

    enum AnimalKind { // вид животного
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }

    public AnimalKind getKind() { //возвращает вид животного
        return AnimalKind.ANIMAL;
    }

    enum FoodKind { // вид еды
        UNKNOWN,
        HAY,
        CORN
    }

    public FoodKind getFoodKind() { //возвращает вид еды
        return FoodKind.UNKNOWN;
    }


    public String toString() { //возвращает информацию о животном в формате: I am <AnimalKind>, eat <FoodKind>
        return ("I am " + this.getKind() + ", eat " + this.getFoodKind());
    }

    public double getFoodCoeff() { //возвращает коэффициент веса еды к весу тела животного
        switch (getKind()) {
            default:
                return 0.02;
        }
    }

    public double calculateFoodWeight() { // рассчитывает необходимый вес еды, по формуле - вес-еды = вес-животного * коэффициент веса тела.
        return this.getWeight() * this.getFoodCoeff();
    }

    public String toStringFull() { //возвращет информацию о животном в формате: I am <AnimalKind>, eat <FoodKind> <CalculateFoodWeight>
        return ("I am " + this.getKind() + ", eat " + this.getFoodKind() + " " + this.calculateFoodWeight());
    }

    public static void printInfo(Animal animal) { // выводит информацию о типе животного и виде его еды
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
