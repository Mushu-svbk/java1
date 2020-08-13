package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    static byte num;

    public Binary(byte num) {
        Binary.num = num;
    }

    public String toString() {
        if (num == 0) return "00000000";
        StringBuilder value = new StringBuilder();
        int result = num;
        for (int i = 0; i < 8; i++) {
            value.insert(0, (result & 0b1));
            result >>= 1;

        }
        return value.toString();
    }

    public static void main(String[] args) {
        Binary number = new Binary((byte) 0);
        System.out.println(Binary.num + " : " + number.toString());
        Binary number2 = new Binary((byte) 1);
        System.out.println(Binary.num + " : " + number2.toString());
        Binary number3 = new Binary((byte) 127);
        System.out.println(Binary.num + " : " + number3.toString());
        Binary number4 = new Binary((byte) -128);
        System.out.println(Binary.num + " : " + number4.toString());
        Binary number5 = new Binary((byte) -1);
        System.out.println(Binary.num + " : " + number5.toString());
    }
}
