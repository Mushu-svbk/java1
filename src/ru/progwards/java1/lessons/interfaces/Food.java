package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Food otherFood = (Food) smthHasWeigt;
        int foodcompare = Double.compare(this.getWeight(), otherFood.getWeight());
        switch (foodcompare) {
            case (-1):
                return CompareWeight.CompareResult.LESS;
            case (0):
                return CompareWeight.CompareResult.EQUAL;


        }
        return CompareWeight.CompareResult.GREATER;
    }

    public double getWeight() {
        return weight;
    }
}
