package my.all.test;

import java.util.HashSet;
import java.util.Set;

public class Test132 {

    public static Set<Integer> unionOfSets(final Set set1, final Set set2) {
        HashSet result = new HashSet(set1);
        result.addAll(set2);
        System.out.println(result.size());
        return null;
    }

    static class Figure {
        public String figDetect(Figure fig) {
            if (fig == null) return "Неизвестная фигура";
            if (fig.getClass() == Square.class) return "Сторона квадрата " + ((Square) fig).getSide();
            if (fig.getClass() == Round.class) return "Диаметр круга " + ((Round) fig).getDiameter();
            return "Неизвестная фигура";
        }
    }

    static class Square extends Figure {
        private final double side;
        public Square(double side) {
            this.side = side;
        }
        public double getSide() {
            return side;
        }
    }

    static class Round extends Figure {
        private double diameter;
        public Round(double diameter) {
            this.diameter = diameter;
        }

        public Round(Figure figure) {
            super();
        }

        public double getDiameter() {
            return diameter;
        }
    }

    public static void main(String[] args) {
        Set<Integer> intSet1 = Set.of(1, 3, 5, 12, 45);
        Set<Integer> intSet2 = Set.of(12, 44, 2, 1, 4);

        Set<Integer> union = unionOfSets(intSet1, intSet2);
        System.out.println(intSet1);
        System.out.println(intSet2);
        System.out.println(union);

        System.out.println(new Figure().figDetect(new Figure()));
        System.out.println(new Figure().figDetect(new Square(5.0)));
        System.out.println(new Figure().figDetect(new Round(12.0)));
        System.out.println(new Figure().figDetect(null));
    }

}
