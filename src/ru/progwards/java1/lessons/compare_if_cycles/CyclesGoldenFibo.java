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
        final double OTN_MIN = 1.61703, OTN_MAX = 1.61903;
        double osn, reb;
        //  определить ребро и основание
        if (a==b){reb = (double)a; osn = (double)c;}
        else if (a==c){reb = (double)a; osn = (double)b;}
        else if (c==b){reb = (double)c; osn = (double)a;}
        else return false;
        if (reb/osn > OTN_MIN && reb/osn < OTN_MAX)
            return true;
        else
            return false;
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

        int n0 = 1;
        int n1 = 1;
        int n2;
        System.out.print(n0+" "+n1+" ");
        for(int i = 3; i <= 15; i++){
            n2=n0+n1;
            System.out.print(n2+" ");
            n0=n1;
            n1=n2;
        }

        System.out.println();

        System.out.println("");

        System.out.println(isGoldenTriangle(3, 3, 2));
        System.out.println(isGoldenTriangle(3, 3, 2));
        System.out.println(isGoldenTriangle(5, 5, 3));
        System.out.println(isGoldenTriangle(8, 8, 5));
        System.out.println(isGoldenTriangle(21, 13, 13));
        System.out.println(isGoldenTriangle(21, 21, 13));
        System.out.println(isGoldenTriangle(21, 21, 34));
        System.out.println(isGoldenTriangle(55, 89, 55));
        System.out.println(isGoldenTriangle(89, 89, 55));
    }
}
