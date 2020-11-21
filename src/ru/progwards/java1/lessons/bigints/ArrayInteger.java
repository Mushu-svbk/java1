package ru.progwards.java1.lessons.bigints;
import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
    byte[] digits;
    int signif;

    ArrayInteger(int n) {
        this.digits = new byte[n];
    }

        void fromInt(BigInteger value) {
        int volume = 0;
        String starr = value.toString(10);
        for (int i = 0; i < starr.length(); i++) {
            String swap = starr.substring(i, i + 1);
            digits[i] = Byte.parseByte(swap);
            volume += 1;
        }
        digits = Arrays.copyOf(digits, volume);

    }

    BigInteger toInt() {
        StringBuilder str = new StringBuilder();

        for (byte digit : digits) {
            str.insert(0, digit);
        }

        return new BigInteger(str.toString());
    }

    boolean add2(ArrayInteger num) {
        int count = 0;
        if (digits.length < num.digits.length) {
            fromInt(new BigInteger("0"));
            return false;
        } else if (digits.length == num.digits.length) {
            for (int i = this.digits.length - 1; i >= 0; i--) {
                this.digits[i] = (byte) (this.digits[i] + num.digits[i]);
                if (this.digits[i] >= 10) {
                    if (i == 0) {
                        fromInt(new BigInteger("0"));
                        return false;
                    }

                    this.digits[i] -= 10;
                    this.digits[i - 1] += 1;
                }
            }
        } else {
            for (int i = this.digits.length - 1; i >= 0; i--) {
                this.digits[i] += num.digits[num.digits.length - 1 - count];
                count++;
                if (this.digits[i] >= 10) {
                    if (i == 0) {
                        fromInt(new BigInteger("0"));
                        return false;
                    }

                    this.digits[i] -= 10;
                    this.digits[i - 1] += 1;
                }
            }
        }
        return true;
    }

    boolean add(ArrayInteger num) {
        int sigMax = num.signif >= signif ? num.signif : signif; // max significant
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
                if (sig >= l) return false;
                digits[sig] = (byte) (r % 10);
            } else {
                if (i < l) digits[i] = 0;
            }
            p = r / 10;
        }
        signif = sig + 1;
        return true;
    }

    @Override
    public String toString() {
        return "ArrayInteger{" +
                "digits=" + Arrays.toString(digits) +
                '}';
    }

    public static void main(String[] args) {
        ArrayInteger arr1 = new ArrayInteger(12);
        ArrayInteger arr2 = new ArrayInteger(18);
//        System.out.println(Arrays.toString(arr1.digits));
        arr1.fromInt(new BigInteger("15001"));
        System.out.println(Arrays.toString(arr1.digits));
        arr2.fromInt(new BigInteger("333578"));
        System.out.println(Arrays.toString(arr2.digits));
        System.out.println(arr1.add(arr2));
        System.out.println(arr1.toString());
    }
}
