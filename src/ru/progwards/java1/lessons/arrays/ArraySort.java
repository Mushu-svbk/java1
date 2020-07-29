package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a) { //Реализует метод, сортирующий произвольный массив целых чисел путем сравнения двух из них и перестановкой
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int minId = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minId = j;
                }
            }
            // замена
            int temp = a[i];
            a[i] = min;
            a[minId] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {-81, 25, 15, -32, 31, -88, 0, -95, -2, 104, -4, 11, 9, -17};
        System.out.println("Массив до сортировки " + Arrays.toString(a));

        System.out.println("");

        sort(a);
        System.out.println("Массив после сортировки " + Arrays.toString(a));


    }
}
