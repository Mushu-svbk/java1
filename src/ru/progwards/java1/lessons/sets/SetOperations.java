package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {     //объединение множеств
        HashSet<Integer> res= new HashSet<>(set1);
        res.addAll(set2);
        return res;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {   //пересечение множеств
        if (set1 == null || set2 == null) return new HashSet<>();
        HashSet<Integer> res = new HashSet<>(set1);
        res.retainAll(set2);
        return res;
    }

    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {   //разница множеств
        if(set1==null)return new HashSet<>();
        HashSet<Integer>res= new HashSet<>(set1);
        if(set2!=null)res.removeAll(set2);
        return res;
    }

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {   //Симметрическая разница
        Set<Integer>res1=set1!=null? new HashSet<>(set1) : new HashSet<>();
        Set<Integer>res2=set2!=null? new HashSet<>(set2) : new HashSet<>();
        res1.removeAll(set2);
        res2.removeAll(set1);
        res1.addAll(res2);
        return res1;
    }

    public static void main(String[] args) {

        Set<Integer> intSet1 = Set.of(0, 1, 2, 7, 5, 8, 9);
        Set<Integer> intSet2 = Set.of(0, 2, 3, 4, 8, 7, 9, 11);
        Set<Integer> union = union(intSet1, intSet2);
        Set<Integer> intersection = intersection(intSet1, intSet2);
        Set<Integer> difference = difference(intSet1, intSet2);
        Set<Integer> symDifference = symDifference(intSet1, intSet2);

        System.out.println("Set1 " + intSet1);
        System.out.println("Set2 " + intSet2);
        System.out.println("Объединение множеств " + union);
        System.out.println("Размер объединенного множества " + union.size());

        System.out.println("Пересечение множеств" + intersection);
        System.out.println("Размер пересечения " + intersection.size());

        System.out.println("Разница множеств " + difference);
        System.out.println("Размер разницы множеств " + difference.size());

        System.out.println("Симметричные множества " + symDifference);
        System.out.println("Размер " + symDifference.size());
    }
}
