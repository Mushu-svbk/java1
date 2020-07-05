package my.all.test;

public class TTest4_Factorial {
    static long factorial(long n) {
        long result = 1;

        for (int factor = 2; factor <= n; factor++) {
            result *= factor;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(15));
    }
}
