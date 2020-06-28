package ru.progwards.java1.lessons.basics;

public class Astronomy {
    final static double Pi = 3.14;

    public static double sphereSquare(double r) { //вычисляет площадь поверхности сферы радиуса R по формуле S = 4πR2
        return 4 * Pi * (r * r);
    }
    public static double earthSquare() { //вычисляет площадь поверхности Земли, считая радиус равным 6 371.2 км и используют функцию sphereSquare
        final double r = 6371.2;
        return 4 * Pi * (r * r);
    }
    public static Double mercurySquare() { //которая вычисляет площадь поверхности Меркурия, считая радиус равным 2 439,7 км  и используют функцию sphereSquare
        final double r = 2439.7;
        return 4 * Pi * (r * r);
    }
    public static Double jupiterSquare() { //вычисляет площадь поверхности Юпитера, считая радиус равным 71 492 км  и используют функцию sphereSquare
        final double r = 71492;
        return 4 * Pi * (r * r);
    }
    public static Double earthVsMercury() { //вычисляет отношение площади поверхности Земли к площади поверхности Меркурия используя готовые функции площадей планет
        return earthSquare()/mercurySquare();
    }
    public static Double earthVsJupiter() { //вычисляет отношение площади поверхности Земли к площади поверхности Юпитера используя готовые функции площадей планет
        return earthSquare()/jupiterSquare();
    }

    public static void main(String[] args) {
        System.out.println(sphereSquare(0));
        System.out.println(sphereSquare(6371.2));
        System.out.println(sphereSquare(2439.7));
        System.out.println(sphereSquare(71492));
        System.out.println(earthVsMercury());
        System.out.println(earthVsJupiter());
    }
}
