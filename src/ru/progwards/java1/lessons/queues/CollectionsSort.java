package ru.progwards.java1.lessons.queues;

import java.util.*;

import static java.util.Collections.*;

public class CollectionsSort {

    public static void mySort(Collection<Integer> data){
        Iterator<Integer> id1 = data.iterator();
        int i1 = 0;
        while (id1.hasNext()) {
            Integer num1 = id1.next();
            Iterator<Integer> it2 = data.iterator();
            Integer num2;
            for (int i = i1; i >= 0; i--) it2.next();
            int id2 = i1 + 1;
            while (it2.hasNext()) {
                num2 = it2.next();
                if (num1.compareTo(num2) > 0) {
                    Collections.swap((List)data, i1, id2);
                    num1 = num2;
                }
                id2++;
            }
            i1++;
        }
    }

    public static void minSort(Collection<Integer> data){
        ArrayList<Integer> list = new ArrayList<>(data);
        ArrayList<Integer> result = new ArrayList<>(data.size());

        while (list.size() > 0) {
            Integer min = min(list);
            result.add(min);
            list.remove(min);
        }

        data.clear();
        data.addAll(result);
    }

    static void collSort(Collection<Integer> data){
        Collections.sort((List) data);
    }

    public static Collection<String> compareSort(){
        class BestCompare {
            final String name;
            final long time;

            BestCompare(String name, long time) {
                this.name = name;
                this.time = time;
            }
        }
        class TimeSort implements Comparator<BestCompare> {
            public int compare(BestCompare a, BestCompare b) {
                return Long.compare(a.time, b.time);
            }
        }
        long restime1 = 0;
        long restime2 = 0;
        long restime3 = 0;

        for (int i = 0; i <3; i++) {

            Integer[] anArray = new Integer[1000];
            Random rand = new Random();
            for (int j = 0; j < 1000; j++) {
                anArray[j] = rand.nextInt();
            }

            long time0 = System.nanoTime();
            for (int j = 1; j > 0; j--) {
                ArrayList<Integer> set = new ArrayList<>(Arrays.asList(anArray));
                mySort(set);
            }
            long time1 = System.nanoTime();
            for (int j = 1; j > 0; j--) {
                ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(anArray));
                minSort(ar);
            }
            long time2 = System.nanoTime();
            for (int j = 1; j > 0; j--) {
                ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(anArray));
                collSort(arrayList);
            }
            long time3 = System.nanoTime();
            restime1 += time1 - time0;
            restime2 += time2 - time1;
            restime3 += time3 - time2;
            System.out.println(restime1 / 1000 + " " + "mySort" + " " +
                    restime2 / 1000 + " " + "minSort" + " " + restime3 / 1000 + " " + "collSort");
        }

        ArrayList<BestCompare> listTime = new ArrayList<>(3);
        listTime.add(new BestCompare("mySort", restime1));
        listTime.add(new BestCompare("minSort", restime2));
        listTime.add(new BestCompare("collSort", restime3));

        listTime.sort(new TimeSort());
        System.out.println();

        ArrayList<String> itogSort = new ArrayList<>(3);
        for (BestCompare e : listTime) {
            itogSort.add(e.name);
            System.out.print(itogSort);
        }
        return itogSort;

    }

    public static void main(String[] args) {
        System.out.println(compareSort());
    }
}
