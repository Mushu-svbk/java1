package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a) { //Реализует метод, сортирующий произвольный массив целых чисел путем сравнения двух из них и перестановкой
        int maxValue, maxIndex;
        for (int i = a.length - 1; i >= 0; i--) {
            maxValue = a[i];
            maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (a[j] > maxValue) {
                    maxValue = a[j];
                    maxIndex = j;
                }
            }
            if (maxIndex < i) {
                a[maxIndex] = a[i];
                a[i] = maxValue;
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
