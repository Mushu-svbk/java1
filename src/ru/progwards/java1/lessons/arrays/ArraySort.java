package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a) { //Реализует метод, сортирующий произвольный массив целых чисел путем сравнения двух из них и перестановкой
        int i = 0;
        while (i < a.length) {
            if (i == 0 || a[i-1] <= a[i]) i++;
            else {int tmp = a[i]; a[i] = a[i-1]; a[--i] = tmp;}
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
