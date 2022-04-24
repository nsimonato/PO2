package Exercises.Mag18B;

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
            public int compareTo(S l) {
                return Double.compare(length(), l.length());
            }
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

            public Polyline(List<? extends Point> points) {
                this.points = points;
            }

            @Override
            public double length() {
                double result = 0.;
                Iterator<? extends Point> it = points.iterator();
                Point a = it.next(), b;
                while(it.hasNext()){
                    b = it.next();
                    result += new Segment(a,b).length();
                    a = b;
                }
                return result;
            }
        }

        public static class Point3D extends Point{
            public final double z;
            public Point3D(double x, double y, double z) {
                super(x, y);
                this.z = z;
            }
        }

        public static <T extends Comparable<T>> T max(T a, T b){
            return (a.compareTo(b) >= 0)? a : b;
        }

        public static void main(String[] args) {
            Point a = new Point3D(0., 0., 0.),
                    b = new Point3D(2., 2., 2.),
                    c = new Point3D(2., 0., 3.);

            Polyline abc = new Polyline(List.of(a, b, c)),
                     acb = new Polyline(List.of(a, c, b));

            System.out.println(String.format("max length = %g", max(abc, acb).length()));
            //ab = 2*sqrt(3)
            //bc = sqrt(5)
            //ac = sqrt(13)
            //ab + bc = 2*sqrt(3) + sqrt(5)
            //ac + cb = sqrt(13) + 2*sqrt(3)
        }
    }
}
