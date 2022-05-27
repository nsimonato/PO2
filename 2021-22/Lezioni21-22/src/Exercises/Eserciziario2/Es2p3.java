package Exercises.Eserciziario2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Es2p3 {
    /*
(a) Si implementi un tipo che rappresenta punti bidimensionali immutabili, ovvero una classe Point in cui le
componenti x ed y sono di tipo double.
*/
    public static class Point{
        public final double x,y;
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    /*
(b) Si implementi un tipo che rappresenta segmenti bidimensionali immutabili, ovvero una classe Line il cui
costruttore prende due argomenti di tipo Point. Essa deve fornire un metodo length() che ne calcola la
lunghezza tramite la distanza euclidea tra i due punti.
*/
    public static class Line{
        public final Point a,b;
        Line(Point a, Point b){
            this.a = a;
            this.b = b;
        }

        public double length(){
            return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));
        }
    }

    public static abstract class Polygon {
        protected final List<Point> points;
        protected Polygon(List<Point> points) {
            assert points.size() >= 3;
            this.points = points;
        }
        public Iterator<Line> lineIterator() {
            return new Iterator<Line>() {
                Iterator<Point> p = points.iterator();
                Point a = p.next(), b = p.next();
                @Override
                public boolean hasNext() {
                    return a != null && b != null && p.hasNext();
                }

                @Override
                public Line next() {
                    if(a != null && b != null){
                        Line l = new Line(a,b);
                        a = b;
                        b = p.next();
                        return l;
                    }
                    return null;
                }
            };
        }
        public double perimeter() {
            Iterator<Line> it = lineIterator();
            double result = 0;
            while(it.hasNext()){
                Line current = it.next();
                result += current.length();
            }
            return result;
        }
        public abstract double area();
    }

    /*
ii. Si implementi il metodo lineIterator() che costruisce un iteratore su oggetti di tipo Line e si comporta
come un wrapper dell’iteratore estratto dal campo points. Gli oggetti prodotti dall’iteratore di Line
devono essere costruiti dinamicamente leggendo coppie di punti adiacenti dall’iteratore di Point. Si implementi una logica di caching dell’ultimo punto letto per permettere la costruzione di un nuovo segmento
adiacente all’ultimo ad ogni invocazione del metodo next(). Si badi inoltre a riusare opportunamente il
primo punto come secondo estremo dell’ultimo segmento costruito.*/

    /*
iii. Si implementi il metodo perimeter() in funzione del metodo lineIterator(), ovvero calcolando il
perimetro del poligono iterando sui segmenti che lo compongono.
    */

    public static class Triangle extends Polygon {
        public Triangle(Point p1, Point p2, Point p3) {
            super(List.of(p1,p2,p3));
        }
        @Override
        public double area() {
            double p = perimeter() / 2.;
            double a = new Line(points.get(1), points.get(2)).length();
            double b = new Line(points.get(2), points.get(3)).length();
            double c = new Line(points.get(1), points.get(3)).length();
            return Math.sqrt(p*(p-a)*(p-b)*(p-c));
        }
    }

    /*
ii. Si implementi un tipo che rappresenta triangoli rettangoli tramite una sottoclasse di Triangle. Si badi in
particolar modo a definire un costruttore che sintetizzi al massimo le informazioni passate come argomenti.
Si prediligano i controlli statici a quelli dinamici, se possibile, e si tenti di minimizzare i casi di ambiguit`a
o gli stati di invalidit`a dell’oggetto; nel caso in cui si ritenga necessario fare dei controlli a runtime, si usi
il costrutto assert.*/

    public static class RectTriangol extends Triangle{
        double c1, c2;
        public RectTriangol(Point o, double c1, double c2) {
            super(o, new Point(o.x + c1, o.y), new Point(o.x, o.y + c2));
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public double area(){
            return c1*c2/2;
        }

        public double perimeter(){
            return c1 + c2 + Math.sqrt(c1*c1 + c2*c2);
        }
    }

    public static class Rectangle extends Polygon {
        public Rectangle(Point p1, Point p3) {
            super(List.of(p1,new Point(p1.x, p3.y),p3, new Point(p3.x, p1.y)));}
        @Override
        public double area() {
            double b = new Line(points.get(0), points.get(1)).length();
            double c = new Line(points.get(0), points.get(2)).length();
            return b*c;
        }
    }

    public static class Square extends Rectangle {
        public Square(Point p1, double side) {
            super(p1, new Point(p1.x + side, p1.y + side));
        }
    }
}
