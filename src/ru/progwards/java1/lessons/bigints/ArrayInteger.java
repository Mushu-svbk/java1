package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ArrayInteger {
    byte[] digits; // массив цифр от 0 до 9
    int infos; // сколько цифр в даное время значимых

    ArrayInteger() {
        int n = 10;
        digits = new byte[n];
        clear(n);
    }

    ArrayInteger(String value) {
        this();
        fromString(value);
    }
    private void clear() {
        clear(infos);
    }
    private void clear(int count) {
        for (int i = 0; i < count; i++) digits[i] = 0;
        infos = 0;
    }
    void fromString(String value) {
        char[] s = value.toCharArray();
        int sig = s.length;
        // переведем массив к числовому
        for (int i = sig - 1, k = 0; i >= 0; i--, k++) {
            digits[k] = (byte) (s[i] - '0');
        }
        // обнулим ранее использовавшиеся
        for (int i = sig; i < infos; i++) {
            digits[i] = 0;
        }
        infos = sig;
    }
    void fromInt(BigDecimal value) {
        fromString(value.toString());
    }
    BigInteger toInt() {
        char[] s = new char[infos];
        for (int i = infos - 1, k = 0; i >= 0; i--, k++) {
            s[i] = (char)((digits[k] + '0') & 0xFF);
        }
        return new BigInteger(String.valueOf(s));
    }

    boolean raiseCalcError(){
        clear(digits.length);
        return false;
    }
    boolean add(ArrayInteger num) {
        int sigMax = num.infos >= infos ? num.infos : infos; // max
        int l = digits.length;
        int ln = num.digits.length;
        int p = 0; // перенос
        int r; // результат для цифр
        int sig = 0; // ИНДЕКС последнего значащего
        for (int i = 0; i <= sigMax; i++) {
            r = p;
            if (i < l) r += digits[i];
            if (i < ln) r += num.digits[i];
            if (r > 0) {
                sig = i;
                if (sig >= l) return raiseCalcError();
                digits[sig] = (byte) (r % 10);
            } else {
                if (i < l) digits[i] = 0;
            }
            p = r / 10;
        }
        infos = sig + 1;
        return true;
    }

    @Override
    public String toString() {
        byte[] r = new byte [infos];
        for (int i = infos - 1, k = 0; i >= 0; i--, k++) {
            r[k] = (byte) (digits[i] + '0');
        }
        return new String(r);
    }

    public static void main(String[] args) {
        ArrayInteger a = new ArrayInteger("555");
        ArrayInteger b = new ArrayInteger("11");
        System.out.print(a + " + " + b + " = ");
        a.add(b);
        System.out.println(a);
    }
}
