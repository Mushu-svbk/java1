package my.test2;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class test131 {
    public static Set<Integer> a2set(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) set.add(i);
        return set;
    }

    public static void iSetTest() {
        Set<Integer> iSet = new HashSet<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                iSet.add(i+j);
            }
        System.out.println(iSet.size());
    }

    public static void wSetTest() {
        String TEXT = "на дворе трава на траве дрова не руби дрова на траве двора";
        Set<String> wordSet = new HashSet<>(Arrays.asList(TEXT.split(" ")));

        Iterator<String> iter = wordSet.iterator();
        while (iter.hasNext())
            if (iter.next().contains("ра"))
                iter.remove();

        System.out.println(wordSet.size());
    }

    public static void cset() {
        Set<Integer>  fiboSet1000 =
                Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987);
        int sum = 0;
        for (int i = 2; i < 10; i++)
            sum += fiboSet1000.contains(i) ? 1 : 0;
        System.out.println(sum);
    }

    public static void main(String[] args) {
        wSetTest();
        cset();

        int[] a = new int[]{0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};
        System.out.println(Arrays.toString(a));
        Set<Integer> set = new test131().a2set(a);
        System.out.println(a2set(a));
        iSetTest();

    }
}
