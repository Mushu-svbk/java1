package my.all.test;

public class Point3D extends Point2D {
    private int z;

    Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        super.toString();
        return (x + "," + y + "," + z);
    }

    public static void main(String[] args) {
        System.out.println(new Point2D(3,12));
        System.out.println(new Point3D(3,12,55));
    }

}
