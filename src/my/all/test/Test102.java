package my.all.test;

public class Test102 {

    public static Integer sqr(Integer n) {
        try {
            return n * n;
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("otvet" + sqr(null));
    }
}