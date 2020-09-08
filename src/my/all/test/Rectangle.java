package my.all.test;

import java.util.Objects;

public class Rectangle {
    private final double a;
    private final double b;
    private static double area;

    public Rectangle(double a, double b, double area) {
        this.a = a;
        this.b = b;
        this.area = area;
    }

    public double area() {
        return a*b;
    }

  ///  public int compareTo2(Rectangle other){
   //     if (this.area() > ((Rectangle) other).area()) {
   //         return 1;
   //     } else if (this.area() < ((Rectangle) other).area()) {
   //         return -1;
   //     } else {
   //         return 0;
   //     }
   // }

    public int compareTo(Rectangle other){
       return Double.compare(area(), other.area());
    }


    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Rectangle rectangle = (Rectangle) anObject;
        return Double.compare(rectangle.area(), area()) == 0;
    }


    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public static void main(String[] args) {
         Rectangle rect1 = new Rectangle(1,1, area);
         Rectangle rect2 = new Rectangle(2,3, area);
         Rectangle rect3 = new Rectangle(3,2, area);
         Rectangle rect4 = new Rectangle(2,2, area);
       // Rectangle rect5 = new Rectangle(3,3);
         System.out.println(rect4.compareTo(rect1));
        System.out.println(rect2.compareTo(rect3));
       // System.out.println(rect2.compareTo(rect3));
       // System.out.println(rect4.compareTo(rect5));
         // System.out.println(rect4.compareTo2(rect1));
       // System.out.println(rect2.compareTo2(rect3));
       // System.out.println(rect4.compareTo2(rect5));
    }
}
