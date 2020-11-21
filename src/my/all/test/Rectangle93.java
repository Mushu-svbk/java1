package my.all.test;

import java.math.BigDecimal;

public class Rectangle93 {
    static class Rectangle {

        Rectangle(BigDecimal a, BigDecimal b) {
            this.a = a;
            this.b = b;
        }
        public BigDecimal a;
        public BigDecimal b;

        @Override
        public String toString() {
            return "Rectangle{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    // возвращает true если площади прямоугольников равны
    static boolean rectCompare(Rectangle r1, Rectangle r2) {
        BigDecimal s1 = r1.a.multiply(r1.b);
        BigDecimal s2 = r2.a.multiply(r2.b);
        return s1.compareTo(s2) == 0;
    }
}
