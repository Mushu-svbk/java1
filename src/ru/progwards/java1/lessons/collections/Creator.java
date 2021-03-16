package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Creator {

    public static Collection<Integer> fillEven(int n) { //создать коллекцию и заполнить последовательностью четных возрастающих чисел начиная с 2, количество элементов в коллекции n
        int v = 2;
        Collection<Integer> result = new ArrayList<>();
        for (int i = n; i > 0; i--, v += 2) result.add(v);
        return result;
    }

    public static Collection<Integer> fillOdd(int n) { // создать коллекцию и заполнить последовательностью нечетных убывающих чисел, минимальное число в коллекции 1, количество элементов в коллекции n
        int v = n * 2 - 1;
        Collection<Integer> result = new ArrayList<>();
        for (int i = n; i > 0; i--, v -= 2) result.add(v);
        return result;
    }

    public static Collection<Integer> fill3(int n) { //создать коллекцию и заполнить ее тройками чисел. Каждая тройка создается по алгоритму: первое число тройки - индекс числа в коллекции, второе - индекс в квадрате, третье - индекс в кубе, количество элементов в коллекции n*3
        Collection<Integer> result = new ArrayList<>();
        int i2;
        for (int i = 0; i < n; i++) {
            result.add(i);
            i2 = i * i;
            result.add(i2);
            result.add(i2 * i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fillEven(6));
        System.out.println(fillOdd(6));
        System.out.println(fill3(3));
    }
}
