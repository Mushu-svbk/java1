package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int[] startArray;
    private int[] lastArray;
    private int num;

    private int pos;

    DIntArray() {
        this.startArray = new int[0];
    }

    DIntArray(int[] x) { //конструктор - по умолчанию
        this.startArray = x;
    }
    public void add(int num) { //добавляет элемент num в конец массива, при этом размер массива должен увеличиться на 1
        lastArray = new int[startArray.length + 1];
        System.arraycopy(startArray, 0, lastArray, 0, startArray.length);
        lastArray[lastArray.length - 1] = num;
        startArray = lastArray;
    }

    public void atInsert(int pos, int num) { //добавляет элемент num в позицию pos массива, при этом размер массива должен увеличиться на 1
        lastArray = new int[startArray.length + 1];
        System.arraycopy(startArray, 0, lastArray, 0, pos);
        lastArray[pos] = num;
        System.arraycopy(startArray, pos, lastArray, pos + 1, startArray.length - pos);
        startArray = lastArray;
    }

    public void atDelete(int pos) { //удаляет элемент в позиции pos массива, при этом размер массива должен уменьшиться на 1
        lastArray = new int[startArray.length - 1];
        System.arraycopy(startArray, 0, lastArray, 0, pos);
        System.arraycopy(startArray, pos, lastArray, pos - 1, startArray.length - pos);
        startArray = lastArray;
    }


    public int at(int pos) { //возвращает элемент по индексу pos
        this.num = startArray[pos];
        return this.num;
    }

    public static void main(String[] args) {
        int[] x = {2, -7, 12, 24, 67, 52, -15, -21, 0, -1};
        DIntArray mass = new DIntArray(x);
        mass.atInsert(4, 18);
        System.out.println(Arrays.toString(mass.lastArray));
        mass.add(5);
        mass.atInsert(5, -11);
        System.out.println(Arrays.toString(mass.lastArray));
        mass.atDelete(3);
        System.out.println(Arrays.toString(mass.lastArray));
        mass.atDelete(4);
        System.out.println(Arrays.toString(mass.startArray));
        mass.at(8);
        System.out.println(mass.at(7));
    }
}
