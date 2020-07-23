package my.all.test;

public class Arrays {
    public static int sumArrayItems(int[] a) {
        int sum=0;
        for(int i:a) {
            sum+=i;
        }
        return sum;
    }

    public static int sumArrayItems2(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {5, 9, 15};
        System.out.println("Сумма всех натуральных чисел массива " + sumArrayItems(a));
        System.out.println("Сумма всех натуральных чисел массива " + sumArrayItems2(a));
    }
}
