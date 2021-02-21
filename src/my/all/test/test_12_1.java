package my.all.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class test_12_1 {
    public static void main(String[] args) {
        Collection<Integer> numbers = new ArrayList();
        for(int i=0; i<5; i++)
            numbers.add(i);
    }

    public static List<Integer> listAction(List<Integer> list) {
        if (list == null) return null;
        if (list.size() == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.addAll(list);
        result.remove(Collections.min(result));
        result.add(0, result.size());
        result.add(2, Collections.max(result));
        return result;
    }
}
