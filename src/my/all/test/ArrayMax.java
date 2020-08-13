package my.all.test;

import java.util.Arrays;

public class ArrayMax {
    public static int arrayMax(int[] a){
        if (a.length==0) return 0;
        Arrays.sort(a);
        return a[a.length-1];
    }

    public static void main(String args[]){
        int[] a = new int[]{10, 11, 88, 2, 12, 120};
        System.out.println("Maximum Value is: "+ arrayMax(a));

    }

}
