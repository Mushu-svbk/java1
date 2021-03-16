package my.all.test;

import java.util.*;

public class Test12 {
    public static List<Integer> filter(List<Integer> list) {
        int sum = 0;
        for (int e : list) sum += e;
        List<Integer> result;
        if (list instanceof ArrayList) result = new ArrayList<>();
        else if (list instanceof LinkedList) result = new LinkedList<>();
        else if (list instanceof Vector) result = new Vector<>();
        else if (list instanceof Stack) result = new Stack<>();
        else if (list instanceof List) result = new ArrayList<>();
        else throw new RuntimeException("Unknown 'list' type!");
        int drop = sum / 100;
        for (Integer e : list) if (e < drop) result.add(e);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(Integer e:new Integer[]{40, 300, 0, 4, 3, 1, 2}) list.add(e);
        System.out.println(filter(list));
    }
}
