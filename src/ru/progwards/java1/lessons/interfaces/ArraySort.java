package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort {

    public static void sort(CompareWeight[] a) {
        CompareWeight con;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareWeight((a[j])) == CompareWeight.CompareResult.GREATER) {
                    con = a[i];
                    a[i] = a[j];
                    a[j] = con;
                }
            }
        }
    }

    public static void main(String[] args) {

        CompareWeight[] a = {new Duck(55.0), new Animal(49.0), new Cow(300.0),
                new Hamster(3.3)};

        ArraySort.sort(a);

        System.out.println(Arrays.toString(a));
    }
}