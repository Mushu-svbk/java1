package ru.test.test82;

public class Goat implements Speaking, Eating{
    @Override
    public String eat() {
        return "Сено";
    }

    @Override
    public String say() {
        return "Мее";
    }
    public static void main(String[] args) {
        Dog say = new Dog();
        System.out.println("Собака лает: " +(new Dog().say()));
        Dog eat = new Dog();
        System.out.println("Собака  любит: " +(new Dog().eat()));
        Goat say1 = new Goat();
        System.out.println("Козёл говорит: " +(new Goat().say()));
        Goat eat1 = new Goat();
        System.out.println("Любимая еда козла: " +(new Goat().eat()));
    }
}
