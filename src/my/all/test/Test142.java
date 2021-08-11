package my.all.test;

import java.util.ArrayDeque;

public class Test142 {
    static int sumLastAndFirst(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) return 0;
        return deque.peekFirst() + deque.peekLast();
    }

    static int sumLastAndFirst2(ArrayDeque<Integer> deque) {
        int res = deque.peekFirst() + deque.peekLast();
        if (deque.isEmpty()) return 0;
        return res;
    }

    public static void main(String[] args) {
        ArrayDeque deque = new ArrayDeque<>();
        deque.offer(5);
        deque.offer(1);
        deque.offer(8);
        deque.offer(7);
        System.out.println(deque);
        System.out.println(sumLastAndFirst(deque));
        System.out.println(sumLastAndFirst2(deque));
    }
}
