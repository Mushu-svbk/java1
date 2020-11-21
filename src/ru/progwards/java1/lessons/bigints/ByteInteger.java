package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    byte value;
    ByteInteger(byte value) {
        this.value = value;
        bytes = 1;
    }
    @Override
    public String toString() {
        return Byte.toString(value);
    }
    @Override
    protected byte toByte() {
        return value;
    }
    @Override
    protected short toShort() {
        return value;
    }
    @Override
    protected int toInt() {
        return value;
    }
    @Override
    protected AbsInteger add2(AbsInteger num1) {
        return new ByteInteger((byte) (value + num1.toByte()));
    }

}
