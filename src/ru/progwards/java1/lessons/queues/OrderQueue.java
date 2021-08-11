package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {
    static class Order {
        static int num1 = 1;
        private final double sum;
        private final int num;

        public Order(double sum) {
            this.sum = sum;
            this.num = num1++;
        }

        public double getSum() {
            return sum;
        }

        public int getNum() {
            return num;
        }

        @Override
        public String toString() {
            return sum + "(" + num + ")";
        }
    }
    Comparator<Order> orderComparator = (c1, c2) -> {
        int m1 = ((int) c1.getSum() - 1) / 10000 + 1;
        if (m1 < 1) m1 = 1;
        else if (m1 > 3) m1 = 3;
        int m2 = ((int) c2.getSum() - 1) / 10000 + 1;
        if (m2 < 1) m2 = 1;
        else if (m2 > 3) m2 = 3;
        if (m1 == m2) return c1.getNum() - c2.getNum();
        return m2 - m1;
    };

    PriorityQueue<Order> queue = new PriorityQueue<>(16, orderComparator);

    public void add(Order order) {
        queue.add(order);
    }

    public Order get() {
        return queue.poll();
    }

    public Order getNum() {
        return queue.poll();
    }

    public static void main(String[] args) {
        OrderQueue ordq = new OrderQueue();
        ordq.add(new Order(10105.0));
        ordq.add(new Order(28201.0));
        ordq.add(new Order(23860.0));
        ordq.add(new Order(17812.0));
        ordq.add(new Order(20811.0));
        ordq.add(new Order(19808.0));
        ordq.add(new Order(12714.0));
        ordq.add(new Order(10281.0));
        ordq.add(new Order(14527.0));
        ordq.add(new Order(27423.0));
        ordq.add(new Order(12659.0));
        ordq.add(new Order(23425.0));
        ordq.add(new Order(22312.0));
        ordq.add(new Order(5979.0));
        Order ord = ordq.get();
        while (ord != null) {
            System.out.println(ord);
            ord = ordq.get();
        }
    }
}
