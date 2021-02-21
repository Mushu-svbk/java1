package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {

    public static int maxSide(int a, int b, int c) { //сверяет длины сторон треугольника, и возвращает наибольшую длину стороны.
        if ((a >= b && a >= c))
            return a;
        else if ((b >= a && b >= c))
            return b;
        else if ((c >= a && c >= b))
            return c;
        else if (a == b && a == c)
            return a;
        else
            return 0;
    }

    public static int minSide(int a, int b, int c) { //сверяет длины сторон треугольника, и возвращает наименьшую длину стороны.
        if ((a <= b && a <= c))
            return a;
        else if ((b <= a && b <= c))
            return b;
        else if ((c <= a && c <= b))
            return c;
        else if ((a == b && a == c))
            return a;
        else
            return 0;
    }

    public static boolean isEquilateralTriangle(int a, int b, int c) { // возвращает true, если треугольник равносторонний и false в противном случае.
        if ((a == b && a == c))
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        System.out.println(maxSide(5, 15, 6));
        System.out.println(maxSide(5, 12, 12));
        System.out.println(minSide(1, 2, 2));
        System.out.println(minSide(6, 8, 4));
        System.out.println(isEquilateralTriangle(10, 10, 10));
        System.out.println(isEquilateralTriangle(10, 8, 6));
    }
}
