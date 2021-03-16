package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public static Collection<Integer> fill3(int n) {  //создать коллекцию и заполнить ее тройками чисел. Каждая тройка создается по алгоритму:

        List<Integer> list= new ArrayList<>(n * 3);
        int i2=0;
        for (int i = 0; i < n; i++) {
            list.add(i2);
            list.add((int) Math.pow(i2,2));
            list.add(i2*i2*i2);
            i2+=3;

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(fillEven(6));
        System.out.println(fillOdd(6));
        System.out.println(fill3(3));
    }
}
