package Exercises.Mag19;

import java.util.Iterator;

public class Es1 {
    @FunctionalInterface
    public interface BiFunction_<A,B,C>{
        C apply(A first, B second);
    }

    public static class Pair<A,B>{
        public final A first;
        public final B second;
        Pair(A first, B second){
            this.first = first;
            this.second = second;
        }
    }

    public static class Triple<A,B,C> extends Pair<A,B>{
        final C third;
        Triple(A first, B second, C third) {
            super(first, second);
            this.third = third;
        }
    }

    public static <A,B,C> Iterator<Triple<A,B,C>> evalIterator(Iterator<Pair<A,B>> i, BiFunction_<A,B,C> foo){
        return new Iterator<Triple<A, B, C>>() {
            Iterator<Pair<A,B>> it = i;
            BiFunction_<A,B,C> f = foo;

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Triple<A, B, C> next() {
                Pair<A,B> p = it.next();
                A a = p.first;
                B b = p.second;
                if(p != null)
                    return new Triple<>(a, b, f.apply(a, b));
                return null;
            }
        };
    }

}
