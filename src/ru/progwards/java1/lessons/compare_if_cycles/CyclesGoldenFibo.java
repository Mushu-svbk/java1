package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {

    public static boolean containsDigit(int number, int digit) { // возвращать true, если число number содержит цифру digit
        int i = number;
        int part;
        boolean result = false;
        while (i > 0) {
            part = i % 10;
            i = i / 10;
            if (digit == part)
                result = true;
        }
        if (digit == 0 & number == 0)
            result = true;
        return result;
    }

    public static int fiboNumber(int n) { //  возвращает n-ое число Фибоначчи
        int i1 = 1;
        int i2 = 1;
        int i3 = 0;
        int count = 3;
        while (count <= n) {
            i3 = i1 + i2;
            i1 = i2;
            i2 = i3;
            count++;
        }
        if (n == 0 | n == 1 | n == 2) i3 = 1;
        return i3;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) { // возвращает true, если треугольник со сторонами a, b, c является Золотым. Критерии - равнобедреннй и отношение ребра к основанию должно лежать между значениями 1.61703 и 1.61903
        if ((((double) a == (double) b) & ((1.61703 < ((double) a / (double) c)) & (((double) a / (double) c) < 1.61903))) | (((double) b == (double) c) & ((1.61703 < ((double) b / (double) a)) & (((double) b / (double) a) < 1.61903))) | (((double) a == (double) c) & ((1.61703 < ((double) a / (double) b)) & (((double) a / (double) b) < 1.61903))))
            return true;
        else return false;
    }
    public static void main(String[] args) {
        System.out.println(containsDigit(5,5));
        int fibo15 = 15;
        for (int i = 0; i <= fibo15; i++) {
            if (fiboNumber(i) <= 100) {
                for (int n = 0; fiboNumber(n) <= fiboNumber(i); n++) {
                    if (isGoldenTriangle(fiboNumber(i), fiboNumber(i), fiboNumber(n))) {
                        System.out.println(fiboNumber(i) + " " + fiboNumber(i) + " " + fiboNumber(n));
                    }
                }
            }
        }
    }
}
