package my.all.test;

import java.util.Arrays;

public class TTest6_3 {
    public static int arrayMax2(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++)
        {
            if (max<a[i])
                max = a[i];
            if (a.length==0) return 0;
        }
        return max;
    }

    public static int arrayMax(int[] a){
        if (a.length==0) return 0;
        Arrays.sort(a);
        return a[a.length-1];
    }

    public static void main(String[] args) {
        int[] a = {65, 0, -4, 12, 5, 9, 15};
        int[] a2 = {0};
        System.out.println("Массив до сортировки: " + Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("Массив после сортировки: " + Arrays.toString(a));
        System.out.println(arrayMax(a));
    }
}
