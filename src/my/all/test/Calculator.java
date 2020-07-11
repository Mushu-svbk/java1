package my.all.test;

public class Calculator {
    private static int result;

    public Calculator() {
        result = 0;
    }

    public static int set(int num) {
        result = num;
        return result;
    }

    public static int add(int num) {
        result += num;
        return result;
    }

    public static int sub(int num) {
        result -= num;
        return result;
    }

    public int getResult() {
        return result;
    }

    public static void main(String[] args) {
        System.out.println(add(1));
        System.out.println(sub(5));
        System.out.println(set(312));
    }
}
