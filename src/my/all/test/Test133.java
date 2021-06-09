package my.all.test;

import java.util.Iterator;
import java.util.TreeSet;

public class Test133 {
    public static void doTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(9);
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(8);

        StringBuilder s = new StringBuilder();
        Iterator<Integer> iterator = treeSet.descendingIterator();
        while (iterator.hasNext())
            s.append(iterator.next());
        System.out.println(s);
    }

    public static void doTreeSet2() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(19);
        treeSet.add(12);
        treeSet.add(15);
        treeSet.add(10);

        StringBuilder s = new StringBuilder();
        for (Integer integer : treeSet) s.append(integer);
        System.out.println(s);
    }

    static class User {
        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public Integer id;
        public String name;

        User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }


    public static TreeSet<User> createSet() {
        return new TreeSet<>((o1, o2) -> Integer.compare(o2.id, o1.id));
    }

    public static void main(String[] args) {
        doTreeSet();
        doTreeSet2();

        TreeSet<User> backsort =  createSet();
        backsort.add(new User(4, "Вагиф"));
        backsort.add(new User(7, "Марьям"));
        backsort.add(new User(23, "Эльнара"));
        backsort.add(new User(11, "Руслан"));

        System.out.println(backsort);
        System.out.println(backsort.size());
    }
}
