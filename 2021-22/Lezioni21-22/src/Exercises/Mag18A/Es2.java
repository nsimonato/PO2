package Exercises.Mag18A;

import java.util.Iterator;
import java.util.List;

public class Es2 {
    public class Geometry {

        public static class Point {
            public final double x, y;
            public Point(double x, double y) {
                this.x = x;
                this.y = y;
            }
        }

        public static abstract class Line<S extends Line<S>> implements Comparable<S> {
            public abstract double length();

            @Override
            public int compareTo(S l) { return Double.compare(length(), l.length()); }
        }

        public static class Segment extends Line<Segment> {
            private Point p1, p2;

            public Segment(Point p1, Point p2) {
                this.p1 = p1;
                this.p2 = p2;
            }

            @Override
            public double length() {
                return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
            }
        }

        public static class Polyline extends Line<Polyline> {
            private List<? extends Point> points;

            public Polyline(List<? extends Point> points) { this.points = points; }

            @Override
            public double length() {
                double result = 0.0;
                Iterator<? extends Point> it =  points.iterator();
                Point a = it.next(),b;
                while(it.hasNext()){
                    b = it.next();
                    Segment x = new Segment(a,b);
                    result += x.length();
                    a = b;
                }
                return result;
            }
        }

        public static class Point3D extends Point{
            private final double z;
            public Point3D(double x, double y, double z) {
                super(x,y);
                this.z = z;
            }

            public static <T extends Comparable<T>> T max(T a, T b){
                return a.compareTo(b) >= 0 ? a : b;
            }
        }

        public static void main(String[] args) {
            Point a = new Point3D(0., 0., 0.),
                    b = new Point3D(1., 1., 1.),
                    c = new Point3D(2., 0., 3.);

            Polyline abc = new Polyline(List.of(a, b, c)),
                    bac = new Polyline(List.of(b, a, c));

            System.out.println(String.format("max length = %g", Point3D.max(abc, bac).length()));
        }
    }
}
