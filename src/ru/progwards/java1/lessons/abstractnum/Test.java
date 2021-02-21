package ru.progwards.java1.lessons.abstractnum;

public class Test {
    public static void main(String[] args) {
        Number number = new IntNumber(3); //Объем куба в целых числах, со стороной 3
        DoubleNumber number1 = new DoubleNumber(3.0);
        Figure3D fig = new Cube(number);
        System.out.println("Объем куба в целых числах, со стороной 3 = " + fig.volume());

        fig = new Cube(number1); //Объем куба в double, со стороной 3.0
        System.out.println("Объем куба в double, со стороной 3.0 = " + fig.volume());

        Figure3D fig2 = new Pyramid(number); // Объем пирамиды в целых числах, со стороной 3
        Figure3D fig4 = new Pyramid(number1);// Объем пирамиды в double, со стороной 3
        System.out.println("Объем пирамиды в целых числах, со стороной 3 = " + fig2.volume());
        System.out.println("Объем пирамиды в double, со стороной 3.0 = " + fig4.volume());

        Number number2 = new IntNumber(34);
        DoubleNumber number3 = new DoubleNumber(34.0);
        Figure3D fig6 = new Pyramid(number2); // Объем пирамиды в целых числах, со стороной 34
        Figure3D fig7 = new Pyramid(number3);// Объем пирамиды в double, со стороной 34
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
