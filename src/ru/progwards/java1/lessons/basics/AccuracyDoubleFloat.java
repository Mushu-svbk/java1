package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {

    public static double volumeBallDouble(double radius) { //возвращает объём шара с радиусом radius и основана на типе double.
        final double Pi = 3.14;
        return 4 / 3.0 * Pi * radius * radius * radius;
    }
    public static float volumeBallFloat(float radius) { //возвращает объём шара с радиусом radius и основана на типе float
        float b = 3.14F;
        return (float) (4 / 3.0 * b * radius * radius * radius);
    }
    public static double calculateAccuracy(double radius) { //возвращает разницу между функциями volumeBallDouble и volumeBallFloat (они должны быть вызваны из неё с параметром radius)
        final double Pi = 3.14;
        float b = (float) 3.14F;
        return 4 / 3.0 * Pi * radius * radius * radius - (float) (4 / 3.0 * b * radius * radius * radius);
    }

    public static void main(String[] args) {
        System.out.println(volumeBallDouble(1));
        System.out.println(volumeBallDouble(6371.2));
        System.out.println(volumeBallFloat(6371.2F));
        System.out.println(calculateAccuracy(volumeBallDouble(6371.2)-volumeBallFloat(6371.2F)));
    }
}
