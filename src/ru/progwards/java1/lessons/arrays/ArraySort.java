package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a) { //Реализует метод, сортирующий произвольный массив целых чисел путем сравнения двух из них и перестановкой
        int x;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    x = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = x;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {-81, 25, 15, -32, 31, -88, 0, -95, -2, 104, -4, 11, 9, -17};
        System.out.println("Массив до сортировки " + Arrays.toString(x));
        System.out.println("");
        sort(x);
        System.out.println("Массив после сортировки " + Arrays.toString(x));


    }
}
