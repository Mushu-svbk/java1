package ru.progwards.java1.lessons.bigints;

public class AbsInteger {
    protected int bytes;
    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        return num1.bytes >= num2.bytes ? num1.add2(num2) : num2.add2(num1);
    }
    protected AbsInteger add2(AbsInteger num1) {
        return null;
    }
    protected byte toByte() {
        return 0;
    }
    protected short toShort() {
        return 0;
    }
    protected int toInt() {
        return 0;
    }

    public static void main(String[] args) {
        AbsInteger num1 = new ByteInteger((byte)50);
        AbsInteger num2 = new IntInteger(874);
        System.out.println(AbsInteger.add(num1, num2));
    }
}
