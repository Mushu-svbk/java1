package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    public static CacheInfo lastFibo;

    public static class CacheInfo {

        public int n;
        public int fibo;

        public CacheInfo() {

        }
    }

    public static int fiboNumber(int n) {
        if (n <= 1) return n;

        int previous = 0;
        int next = 1;
        int sum =0;

        for (int i = 2; i <= n; i++) {
            sum = previous;
            previous = next;
            next = sum + previous;
        }
        lastFibo = new CacheInfo();
        lastFibo.n = sum + previous;
        lastFibo.fibo = next - sum;

        return next;
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