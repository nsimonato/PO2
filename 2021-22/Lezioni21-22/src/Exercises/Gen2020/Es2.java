package Exercises.Gen2020;

import java.util.*;
import java.util.function.Function;

public class Es2 {

    public interface PositionedSolid {
        Point origin();
    }

    public interface PositionedPolyhedron extends PositionedSolid, Iterable<Point> {}

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

    public static class Cube implements Polyhedron {
        private double side; // lato del cubo

        public Cube(double side){
            this.side = side;
        }

        @Override
        public double area() {
            return 6*side*side;
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
        public PositionedPolyhedron at(Point o) {
            // 3.a: questa anonymous class NON può essere scritta come una lambda perché ha 2 metodi
            return new PositionedPolyhedron() {
                @Override
                public Point origin() {
                    return o;
                }

                @Override
                public Iterator<Point> iterator() {
                    final Point u = o.move(side, side, side);
                    return Arrays.asList(o, o.move(side, 0., 0.), o.move(0., side, 0.), o.move(0., 0., side),
                                         u, u.move(side, 0., 0.), u.move(0., side, 0.), u.move(0., 0., side)).iterator();
                }
            };
        }
    }

    public static class Sphere implements Solid {
        private double ray; // raggio della sfera

        public Sphere(double ray) {
            this.ray = ray;
        }

        @Override
        public double area() {
            return 4.*ray*ray*Math.PI;
        }

        @Override
        public double volume() {
            return 4.*ray*ray*ray*Math.PI/3.;
        }

        @Override
        public PositionedSolid at(Point origin) {
            return () -> origin;
        }
        /* implementare il resto */
    }

    public static void main(String args[]){
        Cube cube1 = new Cube(11.), cube2 = new Cube(23.);
        Sphere sphere1 = new Sphere(12.), sphere2 = new Sphere(35.);
        List<Solid> solids = List.of(cube1, cube2, sphere1, sphere2);
        List<Cube> cubes = List.of(cube1, cube2);
        List<Sphere> spheres = List.of(sphere1, sphere2);
        List<? extends Polyhedron> polys = cubes;

        Collections.sort(cubes);
        Collections.sort(spheres, (s1,s2) -> (Double.compare(s1.area(), s2.area())));
        Collections.sort(spheres, Solid.comparatorBy(Sphere::area));

        ArrayList<Solid> x = new ArrayList<>();
        x.add(cube1);

    }

}
