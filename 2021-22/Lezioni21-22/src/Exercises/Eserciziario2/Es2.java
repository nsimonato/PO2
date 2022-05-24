package Exercises.Eserciziario2;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Es2 {
    /*
    *   (a) Si implementi un tipo che rappresenta punti tridimensionali immutabili nello spazio, ovvero una classe Point
    *       con i campi pubblici x, y e z di tipo double e l’opportuno costruttore.
    *   (b) Si implementi anche un metodo di Point avente firma Point move(double dx, double dy, double dz)
    *       che produce un nuovo punto traslato rispetto a this di dx, dy e dz rispettivamente per ogni dimensione.
    * */

    public static class Point{
        public final double x,y,z;

        public Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Point move(double dx, double dy, double dz){
            return new Point(x + dx, y + dy, z + dz);
        }
    }

    public interface Solid extends Comparable<Solid> {
        double area();
        double volume();
        PositionedSolid at(Point origin);
        static <S extends Solid> int compareBy(Function<S, Double> f, S s1, S s2) {
            return Double.compare(f.apply(s1), f.apply(s2));
        }
        static <S extends Solid> Comparator<S> comparatorBy(Function<S, Double> f) {
            return (s1, s2) -> compareBy(f, s1, s2);
        }
        default int compareTo(Solid s) {
            return compareBy((x) -> x.volume(), this, s);
        }
    }
    public interface Polyhedron extends Solid {
        double perimeter();
        @Override
        PositionedPolyhedron at(Point origin);
    }
    public interface PositionedSolid {
        Point origin();
    }
    public interface PositionedPolyhedron extends PositionedSolid, Iterable<Point> {}

    /*
    * c) Si implementi la classe Cube, con il suo costruttore parametrico sulla lunghezza del lato ed i metodi richiesti
         dalle interfacce implementate.
    * */
    public static class Cube implements Polyhedron {
        private double side; // lato del cubo

        public Cube(double side) {
            this.side = side;
        }

        @Override
        public double area() {
            return side*side*6;
        }

        @Override
        public double volume() {
            return side*side*side;
        }

        @Override
        public double perimeter() {
            return side*12;
        }

        @Override
        public PositionedPolyhedron at(Point origin) {
            return new PositionedPolyhedron() {
                Point o = origin;
                double s = side;
                List<Point> l = List.of(o, o.move(s,0,0), o.move(0,s,0), o.move(s,s,0),
                                           o.move(s,0,s), o.move(0,s,s), o.move(s,s,s), o.move(0,0,s));
                @Override
                public Point origin() {
                    return o;
                }

                @NotNull
                @Override
                public Iterator<Point> iterator() {
                    return l.iterator();
                }
            };
        }
    }

    /*
    * d) No, at() ritorna un'anonymous class che implementa due metodi. La lambda può implementarne al più uno.
    * e) Si implementi la classe Sphere, con il suo costruttore parametrico sulla lunghezza del raggio ed i metodi
         richiesti dalle interfacce implementate:
    * */
    public static class Sphere implements Solid {
        private double ray; // raggio della sfera

        Sphere(double ray){
            this.ray = ray;
        }

        @Override
        public double area() {
            return 4*Math.PI*ray*ray;
        }

        @Override
        public double volume() {
            return  4*Math.PI*ray*ray*ray/3;
        }

        @Override
        public PositionedSolid at(Point origin) {
            return ()->(origin);
        }
        /* implementare il resto */
    }

    /*
    * f) Si ordini in ordine crescente la lista di cubi cubes secondo il valore del volume, scrivendo uno statement
         di invocazione del seguente metodo della classe Collections del JDK.
    * f - iii) */










    public static void main(String[] args) {
        Cube cube1 = new Cube(11.), cube2 = new Cube(23.);
        Sphere sphere1 = new Sphere(12.), sphere2 = new Sphere(35.);
        List<Solid> solids = List.of(cube1, cube2, sphere1, sphere2);
        List<Cube> cubes = List.of(cube1, cube2);
        List<Sphere> spheres = List.of(sphere1, sphere2);
        List<? extends Polyhedron> polys = cubes;

        Collections.sort(cubes);
        Collections.sort(spheres, (s1, s2) -> Double.compare(s1.area(),s2.area()));

       /* Comparator<Cube> cmpCube = Solid.comparatorBy(Cube::perimeter); // a) Si
        Comparator<Solid> cmpSolid = Solid.comparatorBy(Solid::area); ⃝// b) Si
        //Comparator<Sphere> cmpSphere = Solid.comparatorBy(Sphere::perimeter); ⃝// c) No
        //Comparator<Solid> cmpSolid2 = Solid.comparatorBy(Cube::area);  // d) No
        Comparator<Polyhedron> cmpPoly = Solid.comparatorBy(Polyhedron::volume); ⃝// e) Si
        Comparator<Sphere> cmpSphere2 = Solid.comparatorBy(Solid::area); ⃝   // f) No X
        Comparator<Polyhedron> cmpPoly2 = Solid.comparatorBy(Solid::volume);⃝// g) No X
        Comparator<Cube> cmpCube2 = Solid.comparatorBy(Polyhedron::perimeter);  // h) No X*/
    }


}
