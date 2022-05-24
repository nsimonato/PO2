package Exercises.Giu19;

import java.util.*;

public class Es1 {
    public interface Equatable<T> {
        boolean equalsTo(T x);
    }

    public static class Person<P extends Person<P>> implements Equatable<P> {
        public final String name;
        public final int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public boolean equals(Object o) {
            if(o == null || !o.getClass().equals(this.getClass()))
                return false;
            else
                return o == this || this.equalsTo((P) o);
        }
        @Override
        public boolean equalsTo(P other) {
            return this.age == other.age && this.name.equals(other.name);
        }
        @Override
        public String toString() { return name; }
    }

    public static class Artist extends Person<Artist> {
        public final Hair hair;

        public Artist(String name, int age, Hair hair) {
            super(name, age);
            this.hair = hair;
        }

        @Override
        public boolean equalsTo(Artist other) {
            return super.equalsTo(other) && this.hair.equalsTo(other.hair);
        }
    }

    public static class Hair implements Equatable<Hair> {
        public final int length;
        public final Set<Color> colors;
        public Hair(int length, Set<Color> colors) {
            this.colors = colors;
            this.length = length;
        }
        @Override
        public boolean equals(Object o) {
            if(o == null || !o.getClass().equals(this.getClass()))
                return false;
            else
                return o == this || this.equalsTo((Hair) o);
        }
        @Override
        public boolean equalsTo(Hair x) {
            return x.colors == this.colors && x.length == this.length;
        }
    }
    public enum Color {
        BROWN, DARK, BLONDE, RED, GRAY;
    }

    static <T> T max(Collection<? extends T> c, Comparator<? super T> cmp){
        Iterator<? extends T> it = c.iterator();
        T max = it.next();
        while(it.hasNext()){
            T current = it.next();
            if (cmp.compare(max, current) < 0)
                max = current;
        }
        return max;
    }

    public static void main(String args[]){
        Person alice = new Person("Alice", 23),
                david = new Artist("Bowie", 69, new Hair(75, Set.of(Color.RED, Color.BROWN, Color.GRAY)));
        Artist morgan = new Artist("Morgan", 47, new Hair(20, Set.of(Color.GRAY, Color.DARK))),
                madonna = new Artist("Madonna", 60, new Hair(50, Set.of(Color.BLONDE)));
        List<Artist> artists = Arrays.asList((Artist) david, morgan, madonna);
        List<Person> persons = Arrays.asList(alice, david, morgan, madonna);

        max(artists, (Artist o1, Artist o2) -> o1.hair.length * o1.hair.colors.size() - o2.hair.length * o2.hair.colors.size());

        max(artists, (Artist o1, Artist o2) -> o1.name.compareTo(o2.name));


    }


}
