package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {

    public static boolean isTriangle(int a, int b, int c) { // возвращает true, если по данным трём сторонам (a, b, c) можно построить треугольник.
        return (a < b + c) && (b < a + c) && (c < a + b);
    }

    public static boolean isRightTriangle(int a, int b, int c) { // возвращает true, если треугольник со сторонами a, b, c является прямоугольным.
        return (a * a == b * b + c * c) || (b * b == a * a + c * c) || (c * c == a * a + b * b);
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) { // возвращает true, если треугольник со сторонами a, b, c является равнобедренным.
        return a == b || b == c || a == c;
    }

    public static void main(String[] args) {
        System.out.println(isTriangle(2, 6, 7));
        System.out.println(isTriangle(1, 12, 35));
        System.out.println(isRightTriangle(6, 8, 10));
        System.out.println(isRightTriangle(3, 7, 2));
        System.out.println(isIsoscelesTriangle(2, 2, 4));
        System.out.println(isIsoscelesTriangle(1, 3, 4));
    }
}
