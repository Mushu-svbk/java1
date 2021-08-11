package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

public class StackCalc {
    private final ArrayDeque<Double> queue = new ArrayDeque<>();

    public void push(double value) {
        queue.offerLast(value);
    }

    public double pop() {
        return queue.pollLast();
    }

    public void add() {
        if (queue.size() < 2) return;
        queue.offerLast(queue.pollLast() + queue.pollLast());
    }

    public void sub() {
        if (queue.size() < 2) return;
        queue.offerLast(-queue.pollLast() + queue.pollLast());
    }

    public void mul() {
        if (queue.size() < 2) return;
        queue.offerLast(queue.pollLast() * queue.pollLast());
    }

    public void div() {
        if (queue.size() < 2) return;
        Double m18 = queue.pollLast();
        queue.offerLast(queue.pollLast() / m18);
    }
}

class Calculate {
    public static double calculation1() {
        StackCalc r = new StackCalc();
        r.push(2.2);
        r.push(3);
        r.push(12.1);
        r.add();
        r.mul();
        return r.pop();
    }

    public static double calculation2() {
        StackCalc s = new StackCalc();
        s.push(737.22);
        s.push(24);
        s.add();
        s.push(55.6);
        s.push(12.1);
        s.sub();
        s.div(); // (737.22+24)/(55.6-12.1)+
        s.push(19);
        s.push(3.33);
        s.sub(); // (19-3.33)*(
        s.push(87);
        s.push(2);
        s.push(13.001);
        s.push(9.2);
        s.sub();
        s.mul();
        s.add(); // 87+2*(13.001-9.2)
        s.mul();
        s.add();
        return s.pop();
    }

    public static void main(String[] args) {
        try {
            System.out.println(calculation1());
            System.out.println(calculation2());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
