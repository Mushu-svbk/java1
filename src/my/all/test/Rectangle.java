package my.all.test;

public class Rectangle {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {

        return a*b;
    }

    public int compareTo2(Rectangle other){
        if (this.area() > ((Rectangle) other).area()) {
            return 1;
        } else if (this.area() < ((Rectangle) other).area()) {
            return -1;
        } else {
            return 0;
        }
    }

    public int compareTo(Rectangle other){
        return Double.compare(area(), other.area());
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(1,1);
        Rectangle rect2 = new Rectangle(2,3);
        Rectangle rect3 = new Rectangle(3,2);
        Rectangle rect4 = new Rectangle(2,2);
        Rectangle rect5 = new Rectangle(3,3);
        System.out.println(rect4.compareTo(rect1));
        System.out.println(rect2.compareTo(rect3));
        System.out.println(rect4.compareTo(rect5));
    }
}
