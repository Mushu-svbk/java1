package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {
    int value;
    IntInteger(int value) {
        this.value = value;
        bytes = 4;
    }
    @Override
    public String toString() {
        return Integer.toString(value);
    }
    @Override
    protected int toInt() {
        return value;
    }
    @Override
    protected AbsInteger add2(AbsInteger num1) {
        return new IntInteger(value + num1.toInt());
    }
}
