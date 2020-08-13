package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    public static int sumBits(byte value) {
        int sum = 0;
        if (value > 0) {
            while (value > 0) {
                sum += (byte) (value & 0b1);
                value = ((byte) (value >> 1));
            }
            return sum;

        } else if (value < 0) {
            for (int i = 0; i < 8; i++) {
                sum += (byte) (value & 0b1);
                value = ((byte) (value >> 1));
            }
            return sum;

        } else return 0;


    }

    public static void main(String[] args) {
        byte value = (byte) 0b11110101;
        System.out.println(sumBits(value));
    }
}
