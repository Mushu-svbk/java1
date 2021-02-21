package ru.progwards.java1.lessons.abstractnum;

public class Test {
    public static void main(String[] args) {
        Number number = new IntNumber(3); //Объем куба в целых числах, со стороной 3
        Figure3D fig = new Cube(number);
        System.out.println("Объем куба в целых числах, со стороной 3 = " + fig.volume());

        fig = new Cube(new DoubleNumber(3.0)); //Объем куба в double, со стороной 3.0
        System.out.println("Объем куба в double, со стороной 3.0 = " + fig.volume());

        Figure3D fig2 = new Pyramid(number); // Объем пирамиды в целых числах, со стороной 3
        Figure3D fig4 = new Pyramid(new DoubleNumber(3.0));// Объем пирамиды в double, со стороной 3
        System.out.println("Объем пирамиды в целых числах, со стороной 3 = " + fig2.volume());
        System.out.println("Объем пирамиды в double, со стороной 3.0 = " + fig4.volume());

        Number number1 = new IntNumber(34); //Объем куба в целых числах, со стороной 34
        Figure3D fig5 = new Cube(number1);
        System.out.println("Объем куба в целых числах, со стороной 34 = " + fig5.volume());

        Figure3D fig6 = new Pyramid(number1); // Объем пирамиды в целых числах, со стороной 34
        Figure3D fig7 = new Pyramid(new DoubleNumber(34.0));// Объем пирамиды в double, со стороной 34
        System.out.println("Объем пирамиды в целых числах, со стороной 34 = " + fig6.volume());
        System.out.println("Объем пирамиды в double, со стороной 34.0 = " + fig7.volume());
    }

    static void print (Number number) {
        System.out.println(number);
    }

    public Test(){
        Number number = new IntNumber(4);
        print(number);

        DoubleNumber number1 = new DoubleNumber(5.0);
        print(number1);
    }
}
