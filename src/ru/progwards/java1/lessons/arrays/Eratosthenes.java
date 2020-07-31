package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes { //массив чисел, собственно, "решето"
    private final boolean[] sieve;
    int n;
    int i;
    int N;


    public Eratosthenes(int N) { //конструктор, который должен разместить массив sieve с размером в N и заполнить его значениями true, после чего вызвать метод sift()
        sieve = new boolean[N];
        Arrays.fill(sieve, true);

        sift();
    }

    private void sift() { //метод который, собственно и реализует алгоритм Эратосфена, просеивая составные числа. Подсказка - нужно реализовать 2 вложенных цикла, внешний, например по i от 2 до N-1, и внутренний, например по j который будет просеивать числа, кратные переменной внешнего цикла i*j.
        for (int j = 2; j * j <= N; j++) {
            if (sieve[i]) {
                for (int i = j * j; i <= N; i+= j) {
                    sieve[i] = false;
                }
            }
        }
    }

    public boolean isSimple(int n) { //метод, который возвращает sieve[n], что бы можно было узнать, простое число n или составное
        return sieve[n];
    }
    
    public static void main(String[] args) {
        Eratosthenes era = new Eratosthenes(15);
        System.out.println("N = " + era + ", sieve = " + Arrays.toString(era.sieve));
        System.out.println(era.n);
        System.out.println("2 " + era.isSimple(2));
        System.out.println("4 " + era.isSimple(4));
        System.out.println("9 " + era.isSimple(9));
        System.out.println("3 " + era.isSimple(3));
        System.out.println("7 " + era.isSimple(7));
    }

    public String toString() {
        return "Решето Эратосфена{" + n + "}";
    }
}
