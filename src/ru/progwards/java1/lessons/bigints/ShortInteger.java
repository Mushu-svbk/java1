package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {
    short value;
    ShortInteger(short value) {
        this.value = value;
        bytes = 2;
    }
    @Override
    public String toString() {
        return Short.toString(value);
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
        return new ShortInteger((short) (value + num1.toShort()));
    }
}
