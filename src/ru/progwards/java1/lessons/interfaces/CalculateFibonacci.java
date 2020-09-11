package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    static CacheInfo lastFibo;
    static {
        lastFibo = new CacheInfo();
    }

    static class CacheInfo {

        int n; //число, для которого рассчитываем Фибоначчи
        int fibo; //результат расчета

        CacheInfo(){
            n = -1;
        }

        CacheInfo(int n, int fibo) {
            this.n = n;
            this.fibo = fibo;
        }
    }

    // Fibonacci n number
    public static int fiboNumber(int n) {
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

    CalculateFibonacci() {
        lastFibo = new CacheInfo();
    }

    public static CacheInfo getLastFibo() {
        return lastFibo;
    }

    public static boolean clearLastFibo() {
        lastFibo = null;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(fiboNumber(11));
        System.out.println(lastFibo.fibo);
        System.out.println(lastFibo.n);
        System.out.println(clearLastFibo());
        System.out.println(new CacheInfo().fibo);

    }
}