package Exercises.Set19;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Es1 {
    static class Point{
        public final double x,y;

        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    static class Line{
        public final Point a,b;

        public Line(Point a, Point b){
            this.a = a;
            this.b = b;
        }

        public double length(){
            return Math.sqrt(Math.pow(a.x - b.x, 2.) + Math.pow(a.y - b.y, 2.));
        }
    }

    public static abstract class Polygon {
        protected final List<Point> points;
        protected Polygon(List<Point> points) {
            assert points.size() >= 3;
            this.points = points;
        }
        public Iterator<Line> lineIterator() {
            Iterator<Point> p = points.iterator();
            final Point[] last = new Point[2];
            assert p.hasNext();
            last[0] = p.next();
            // A,B, C points
            //Line AB, BC
            return new Iterator<Line>() {
                @Override
                public boolean hasNext() {
                    return p.hasNext();
                }

                @Override
                public Line next() {
                    last[1] = p.next();
                    Line l = new Line(last[0],last[1]);
                    last[0] = last[1];
                    return l;
                }
            };
        }

        public double perimeter() {
            Iterator<Line> it = this.lineIterator();
            double result = 0.;
            while(it.hasNext()){
                result += it.next().length();
            }

            return result;
        }
        public abstract double area();
    }

    public static class Triangle extends Polygon {
        public Triangle(Point p1, Point p2, Point p3) {
            super(List.of(p1,p2,p3));
        }
        @Override
        public double area() {
            Point p1 = points.get(0), p2 = points.get(1), p3 = points.get(2);
            Line base = new Line(p1,p2);
            Line altezza;
            if(p1.x == p2.x){
                altezza = new Line(new Point(p1.x,p3.y),p3);
            } else{
                altezza = new Line(new Point(0.,0.), new Point(0.,0.));
            }
            return base.length()*altezza.length()*0.5;
        }
    }

    public static class RectangleTriangle extends Triangle{

        public RectangleTriangle(Point p1, double a, double b) {
            super(p1, new Point(p1.x + a,p1.y), new Point(p1.x,p1.y + b));
        }
    }

    public static class Rectangle extends Polygon {
        public Rectangle(Point p1, Point p3) {
            super(List.of(p1, new Point(p1.x,p3.y), p3, new Point(p3.x,p1.y)));
        }
        @Override
        public double area() {
            return new Line(points.get(0),points.get(1)).length() * new Line(points.get(1),points.get(2)).length();
        }
    }

    public static class Square extends Rectangle {
        public Square(Point p1, double side) {
            super(p1, new Point(p1.x + side,p1.y + side));
        }
    }

    public static <T extends Polygon> T max(Collection<T> col,Comparator<? super T> comp){
        Iterator<T> it = col.iterator();
        T max = it.next();
        while(it.hasNext()){
            T curr = it.next();
            if(comp.compare(max, curr) > 0)
                max = curr;
        }

        return max;
    }

    public static void main(String args[]){
        Square sq1 = new Square(new Point(10., -4.), 0.1),
                sq2 = new Square(new Point(1., 20.), 0.01);
        Collection<Square> squares = List.of(sq1, sq2);
        Rectangle r = max(squares, new Comparator<Polygon>() {
            @Override
            public int compare(Polygon a, Polygon b) {
                return (int) (a.area() - b.area());
            }
        });
    }

    /*
    3b --> A
    3c --> B
    */
}
