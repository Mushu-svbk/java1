package my.all.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigInteger93 {
    public static void main(String[] args) {
        BigDecimal bigDec1 = BigDecimal.valueOf(10);
        BigDecimal bigDec2 = BigDecimal.valueOf(3);
        BigDecimal result = bigDec1.divide(bigDec2, 5, RoundingMode.HALF_UP);

        System.out.println("BigDec1 " + bigDec1);
        System.out.println("BigDec2 " + bigDec2);
        System.out.println("result " + result);

        MathContext mathContext = new MathContext(3);
        BigDecimal result2 = new BigDecimal("3.3333", mathContext);
        System.out.println("result " + result2);
    }
}
