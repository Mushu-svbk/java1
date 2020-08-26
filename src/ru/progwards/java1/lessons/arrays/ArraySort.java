package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a) { //Реализует метод, сортирующий произвольный массив целых чисел путем сравнения двух из них и перестановкой
        int tmpValue;
        for (int i = 0; i < a.length; i++) {
            // найдем в остатках максимальный
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    tmpValue = a[i];
                    a[i] = a[j];
                    a[j] = tmpValue;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-81, 25, 15, -32, 31, -88, 0, -95, -2, 104, -4, 11, 9, -17};
        System.out.println("Массив до сортировки " + Arrays.toString(a));

        System.out.println(" ");

        sort(a);
        System.out.println("Массив после сортировки " + Arrays.toString(a));


    }
}
