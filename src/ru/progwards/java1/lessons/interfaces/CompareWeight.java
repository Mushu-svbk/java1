package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight {

    enum CompareResult {
        LESS,
        EQUAL,
        GREATER
    }

    default CompareResult compareWeight(CompareWeight smthHasWeight) {
        return null;
    }
}


