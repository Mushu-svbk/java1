package my.all.test;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Test141 {
    static Object dequeueTest() {
        ArrayDeque deque = new ArrayDeque<>();

        for (int i = 0; i <= 10; i++) {
            deque.offer(i);
            if (i%2 == 0)
                deque.poll();
        }

        System.out.println(deque);
        return null;
    }

    static Object pqTest() {
        PriorityQueue pQueue = new PriorityQueue<>();
        pQueue.offer(10);
        pQueue.offer(1);
        pQueue.offer(9);
        pQueue.offer(3);
        System.out.println(pQueue);
        return null;
    }

    ArrayDeque<Integer> array2queue(int[] a) {
        ArrayDeque<Integer> result = new ArrayDeque<Integer>();
        if (a == null) return result;
        for (int e : a) {
            result.offer(e);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(dequeueTest());
        System.out.println(pqTest());
        new Test141().dequeueTest();
        new Test141().pqTest();
        System.out.println(new Test141().array2queue(new int[]{4, 2, 1}));
    }
}
