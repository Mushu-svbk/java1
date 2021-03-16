package ru.progwards.java1.lessons.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator<T> implements Iterator<T> {

    private int size;
    private int position = 0;
    private int stroka = 0;
    private int col = 0;
    private T[][] matrix;

    public MatrixIterator(T[][] matrix) {
        this.matrix = matrix;
        this.size = countElements(matrix);
    }

    private int countElements(T[][] matrix) {
        int count = 0;
        for (T[] stro : matrix) {
            count += stro.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public T next() {
        if (position >= size) {
            throw new NoSuchElementException();
        }
        T element = matrix[stroka][col];
        position++;
        col++;
        while (stroka < matrix.length && col >= matrix[stroka].length) {
            col = 0;
            stroka++;
        }
        return element;
    }

    public static void main(String[] args) {

        Integer[][] matrix = {{1, 2, 3}, {4}, {5, 6}, {7}};
        Iterator<Integer> iterator = new MatrixIterator<Integer>(matrix);
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
