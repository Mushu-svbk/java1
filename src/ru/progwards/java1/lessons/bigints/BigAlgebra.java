package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {
    static BigDecimal fastPow(BigDecimal num, int pow) {
        switch (pow) {
            case 0: return BigDecimal.ONE;
            case 1: return num;
            case 2: return num.multiply(num);
        }
        int pow2 = pow / 2;
        BigDecimal a = num.multiply(num);
        return pow % 2 == 0 ? fastPow(a, pow2) : num.multiply(fastPow(a, pow2));
    }

    private static final FiboCache fiboCache;
    static {
        fiboCache = new FiboCache();
    }

    private static class FiboCache {
        int n = Integer.MAX_VALUE;
        BigInteger f1;
        BigInteger f2;
    }

    static BigInteger fibonacci(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (fiboCache.n == n) return fiboCache.f2;
        boolean fromCache = fiboCache.n < n;
        BigInteger f1 = fromCache ? fiboCache.f1 : BigInteger.ZERO;
        BigInteger f2 = fromCache ? fiboCache.f2 : BigInteger.ONE;
        int i = fromCache ? fiboCache.n : 1;
        while (i++ < n) {
            BigInteger r = f2.add(f1);
            f1 = f2;
            f2 = r;
        }
        fiboCache.n = n;
        fiboCache.f1 = f1;
        fiboCache.f2 = f2;
        return f2;
    }

    public static void main(String[] args) {
        System.out.println("fastPow(BigDecimal.valueOf(6.000098786),5) = " + fastPow(BigDecimal.valueOf(6.000098786),5));
        for (int i = 1; i <= 20; i++)
            System.out.print(fibonacci(i) + " ");
    }
}
