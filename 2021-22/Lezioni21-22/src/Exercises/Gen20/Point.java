package Exercises.Gen20;

public class Point {
    public final double x,y,z;
    Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point move(double dx, double dy, double dz){
        return new Point(this.x + dx, this.y + dy, this.z + dz);
    }

}
