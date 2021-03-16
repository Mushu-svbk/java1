package ru.progwards.java1.lessons.collections;

import java.util.*;

import static ru.progwards.java1.lessons.collections.Creator.*;

public class Finder {

    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) { //найти 2 соседних числа в коллекции сумма которых минимальна, вернуть коллекцию, содержащую индексы этих чисел

        if (numbers == null) return null;

        int prev = 0;
        int idx = 0;
        int sum;
        int minIdx = 0;
        int minSum = Integer.MAX_VALUE;

        for (int num : numbers) {
            if (idx > 0) {
                sum = num + prev;
                if (sum < minSum) {
                    minSum = sum;
                    minIdx = idx;
                }
            }
            prev = num;
            idx++;
        }

        Collection<Integer> result = new ArrayList<>();
        if (minIdx >= 1) result.add(minIdx - 1);
        result.add(minIdx);
        return result;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) { //найти локальные максимумы - числа, которые больше соседа справа и слева. Первый и последний элемент коллекции не может являться локальным  максимумом, вернуть коллекцию, содержащую значения этих максимумов

        if (numbers == null) return null;

        int prev1 = Integer.MAX_VALUE;
        int prev2 = Integer.MAX_VALUE;
        int idx = 0;
        Collection<Integer> result = new ArrayList<>();

        for (int num : numbers) {
            if (idx > 1 && prev1 > num && prev1 > prev2) {
                result.add(prev1);
            }
            prev2 = prev1;
            prev1 = num;
            idx++;
        }

        return result;
    }

    public static boolean findSequence(Collection<Integer> numbers) { //проверить, содержит ли коллекция все числа от 1 до size(), порядок может быть произвольный
        if (numbers == null) return false;
        int size = numbers.size();
        if (size == 0) return false;

        BitSet s = new BitSet(size + 1);
        int i = 1;
        int num;

        for (Integer number : numbers) {
            num = number;
            if (num < 1 || num > size) {
                return false;
            }
            s.set(num, true);
            i++;
        }

        for (i = 1; i <= size; i++)
            if (s.get(i)) {
            } else return false;

        return true;
    }

    public static String findSimilar(Collection<String> names) { //найдите максимальное количество повторяющихся подряд элементов. Результат вернуть в виде строки <элемент>:<количество>, например Василий:5. При равенстве максимального количества у разных повторяющихся элементов, вернуть результат для элемента, повторяющаяся последовательность которого началась с наименьшего индекса.
        if (names == null) return null;
        if (names.size() == 0) return null;

        String maxString = "";
        int maxCount = 0;
        String curString = "";
        int curCount = 0;
        for (String s : names) {
            if (s.compareTo(curString) == 0) {
                curCount++;
            } else {
                if (curCount > maxCount) {
                    maxString = curString;
                    maxCount = curCount;
                }
                curCount = 1;
                curString = s;
            }
        }
        if (curCount > maxCount) {
            maxString = curString;
            maxCount = curCount;
        }

        return maxString + ":" + maxCount;
    }

    public static void main(String[] args) {
        Collection<Integer> e = fillEven(10);
        Collection<Integer> o = fillOdd(10);
        Collection<Integer> t = fill3(10);
        System.out.println(e);
        System.out.println(findMinSumPair(e));
        System.out.println(o);
        System.out.println(findLocalMax(o));
        System.out.println(t);
        System.out.println(findLocalMax(t));
        Collection<Integer> s = new ArrayList<>();
        for (int i = 1; i < 10; i++) s.add(i);
        //s.add(1);
        System.out.println(s);
        System.out.println(findSequence(s));
        List<String> st = new ArrayList<>();
        for (int i = 0; i < 10; i++) st.add("" + (i / (3 + i / 5)));
        st.add(0, 2 + "");
        System.out.println(st);
        System.out.println(findSimilar(st));
    }
}
