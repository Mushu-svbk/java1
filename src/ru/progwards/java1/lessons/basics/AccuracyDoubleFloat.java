package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    final static double Pi = 3.14;

    public static double volumeBallDouble(double radius) { //возвращает объём шара с радиусом radius и основана на типе double.
        final double R = radius * radius * radius;
        return 4/(3 * Pi * R);
    }
    public static float volumeBallFloat(float radius) { //возвращает объём шара с радиусом radius и основана на типе float
        final float R = radius * radius * radius;
        return (float) (4/(3 * Pi * R));
    }
    public static double calculateAccuracy(double radius) { //возвращает разницу между функциями volumeBallDouble и volumeBallFloat (они должны быть вызваны из неё с параметром radius)
        radius = 6371.2;
        final double R = radius * radius * radius;
        float b = (float) 3.14F;
        float temp = (float) 6371.2F;
        final float T = temp * temp * temp;
        return 4/(3 * Pi * R) - (float) 4/(3 * b * T);
    }

    public static void main(String[] args) {
        System.out.println(volumeBallDouble(1));
        System.out.println(volumeBallDouble(6371.2));
        System.out.println(volumeBallFloat(6371.2F));
        System.out.println(calculateAccuracy(6371.2));
    }
}
