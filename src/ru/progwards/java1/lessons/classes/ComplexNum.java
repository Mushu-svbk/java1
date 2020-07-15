package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a;
    int b;

    public ComplexNum(int a, int b) { //конструктор, который инициализирует комплексное число
        this.a = a;
        this.b = b;
    }

    public String toString() { //приведение к строке, выдать в формате a+bi, например, при a=1 и b=56 должно быть выдано 1+56i
        return (this.a + "+" + this.b + "i");
    }

    public ComplexNum add(ComplexNum num) { //сложение комплексных чисел по формуле: (a + bi) + (c + di) = (a + c) + (b + d)i
        int a1, b1;
        a1 = this.a + num.a;
        b1 = this.b + num.b;
        return new ComplexNum(a1, b1);

    }

    public ComplexNum sub(ComplexNum num) { //вычитание комплексных чисел по формуле: (a + bi) - (c + di) = (a - c) + (b - d)i
        int a1, b1;
        a1 = this.a - num.a;
        b1 = this.b - num.b;
        return new ComplexNum(a1, b1);
    }

    public ComplexNum mul(ComplexNum num) { //умножение комплексных чисел по формуле: (a + bi) * (c + di) = (a*c - b*d) + (b*c + a*d)i
        int a1, b1;
        a1 = (this.a * num.a - this.b * num.b);
        b1 = (this.b * num.a + this.a * num.b);
        return new ComplexNum(a1, b1);
    }

    public ComplexNum div(ComplexNum num) { //  деление комплексных чисел по формуле: (a + bi) / (c + di) = (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
        int a1, b1;
        a1 = ((this.a * num.a + this.b * num.b) / (num.a * num.a + num.b * num.b));
        b1 = ((this.b * num.a - this.a * num.b) / (num.a * num.a + num.b * num.b));
        return new ComplexNum(a1, b1);
    }

    public static void main(String[] args) {
        ComplexNum num1 = new ComplexNum(5, 8);
        ComplexNum num2 = new ComplexNum(31, 41);
        System.out.println(num1.add(num2));
        System.out.println(num2.sub(num1));
        System.out.println(num2.mul(num1));
        System.out.println(num2.div(num1));
    }
}
