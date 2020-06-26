package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static int reverseDigits(int number) {
        int resultNumber = 0;
        for (int i = number; i !=0; i /= 10) {
            resultNumber = resultNumber * 10 + i % 10;
        }
        return resultNumber;
    }

    public static void main(String[] args) {
        System.out.println(reverseDigits(123));
    }
}
