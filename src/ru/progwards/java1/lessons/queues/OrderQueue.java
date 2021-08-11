package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {

    Comparator<Order> orderComparator = (o1, o2) -> {

        int ord1 = ((int) o1.getSum() - 1) / 10000 + 1;

        if (ord1 < 1)
            ord1 = 1;
        else if (ord1 > 3)
            ord1 = 3;

        int ord2 = ((int) o2.getSum() - 1) / 10000 + 1;

        if (ord2 < 1)
            ord2 = 1;
        else if (ord2 > 3)
            ord2 = 3;

        if (ord1 == ord2)
            return o1.getNum() - o2.getNum();
        return ord2 - ord1;
    };


    PriorityQueue<Order> priorityQueue = new PriorityQueue<>(20, orderComparator);

    public void add(Order order) {
        priorityQueue.add(order);
    }

    public Order get() {
        return priorityQueue.poll();
    }

    public Order getNum() {
        return priorityQueue.poll();
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
