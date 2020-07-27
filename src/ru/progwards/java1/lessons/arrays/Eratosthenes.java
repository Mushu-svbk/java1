package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes { //массив чисел, собственно, "решето"
    private boolean[] sieve;
    int n;

    public Eratosthenes(boolean[] sieve, int n) {
        this.sieve = sieve;
        this.n = n;
    }

    public Eratosthenes(int N) { //конструктор, который должен разместить массив sieve с размером в N и заполнить его значениями true, после чего вызвать метод sift()
        sieve = new boolean[N + 1];
        Arrays.fill(sieve, true);

        sift();
    }


    private void sift() { //метод который, собственно и реализует алгоритм Эратосфена, просеивая составные числа. Подсказка - нужно реализовать 2 вложенных цикла, внешний, например по i от 2 до N-1, и внутренний, например по j который будет просеивать числа, кратные переменной внешнего цикла i*j.
        for (int i = 0; i < this.n; i++) sieve[i] = true;

        for (int J = 2; J * J <= this.n; J++)

            if (sieve[J] == true)

                for (int i = J * J; i <= this.n; i += J)

                    sieve[i] = false;
    }

    public boolean isSimple(int n) { //метод, который возвращает sieve[n], что бы можно было узнать, простое число n или составное
        if (n % 2 == 0 && n != 2) return false;
        int max = n * n;
        for (int i = 3; i <= max; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Решето Эратосфена{" + n + "}";
    }

    public static void main(String[] args) {
        Eratosthenes era = new Eratosthenes(25);
        System.out.println("N = " + era + ", sieve = " + Arrays.toString(era.sieve));
        System.out.println(era.n);
        System.out.println(era.isSimple(2));
        System.out.println(era.isSimple(4));
        System.out.println(era.isSimple(30));
    }
}
