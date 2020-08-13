package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    static byte num;

    public Binary(byte num) {
        this.num = num;
        toString();
    }

    public String toString() {
        if (num == 0) return "00000000";
        String value = "";
        int result = num;
        for (int i = 0; i < 8; i++) {
            value = (result & 0b1) + value;
            result >>= 1;

        }
        return value;
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
