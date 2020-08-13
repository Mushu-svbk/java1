package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
    public static int checkBit(byte value, int bitNumber) {
        return value >> bitNumber & 1;
    }


    public static void main(String[] args) {
        byte value = (byte) 35;
        System.out.println(checkBit(value, 0));
        System.out.println(checkBit(value, 1));
        System.out.println(checkBit(value, 2));
        System.out.println(checkBit(value, 3));
        System.out.println(checkBit(value, 4));
        System.out.println(checkBit(value, 5));
    }
}
