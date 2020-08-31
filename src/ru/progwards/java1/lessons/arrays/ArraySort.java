package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a) { //Реализует метод, сортирующий произвольный массив целых чисел путем сравнения двух из них и перестановкой
        int tmpValue;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    tmpValue = a[i];
                    a[i] = a[j];
                    a[j] = tmpValue;
                }
            }
        }
    }
    
 //   public static void sort2(int[] a) {
//        for (int i=0;i<(a.length-1);i++){
 //           int minimumItem = a[i];
            //Сравниваем элементы по индексу i и i+1, если второй меньше, то меняем их местами
 //           checkItemsWithMinimum(minimumItem,i,i+1,a);
//
 //       }
 //   }

 //   private static void checkItemsWithMinimum(int minimum,int minindex,int index,int[] array){
 //       for(int i=index;i<array.length;i++){
 //           if (minimum > array[i]){
 //              array[minindex]=array[i];
 //               array[i]=minimum;
//                minimum=array[minindex];
//
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] a = {-81, 25, 15, -32, 31, -88, 0, -95, -2, 104, -4, 11, 9, -17};
        System.out.println("Массив до сортировки " + Arrays.toString(a));

        System.out.println(" ");

        sort(a);
        System.out.println("Массив после сортировки " + Arrays.toString(a));

        System.out.println(" ");

 //       sort2(a);
//        System.out.println("Массив после сортировки 2 " + Arrays.toString(a));

    }
}
