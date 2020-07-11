package my.all.test;

public class TTest {

    static int addAsStrings(int n1, int n2) {
        String str1 = Integer.toString(n1);
        Integer intObj1 = n2;
        String str2 = intObj1.toString();
        return Integer.parseInt(str1 + str2);
    }

    static int addAsStrings2(int n1, int n2) {
        Integer str1 = Integer.valueOf(n1);
        Integer intObj1 = Integer.valueOf(n2);
        String str2 = intObj1.toString();
        return Integer.parseInt(str1 + str2);
    }

    public static void main(String[] args) {
        System.out.println(addAsStrings(1,2));
        System.out.println(addAsStrings(2,1));
        System.out.println(addAsStrings2(3,4));
        System.out.println(addAsStrings2(4,3));
    }

}
