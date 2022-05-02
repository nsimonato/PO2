package Exercises.Giu18Bis;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Es2 {
    public static class Pair<A,B>{
        final A a;
        final B b;
        Pair(A a, B b){
            this.a = a;
            this.b = b;
        }

        A getFirst(){
            return a;
        }

        B getSecond(){
            return b;
        }
    }

    static <E> Pair<E, E> findMinAndMax(List<E> l, Comparator<E> c){
        Iterator<E> it = l.iterator();
        E min = it.next() , max = min;
        while(it.hasNext()){
            E current = it.next();
            if (c.compare(current, min) < 0)
                min = current;
            if( c.compare(current, max) > 0)
                max = current;
        }

        return new Pair<>(min,max);
    }

    static <E extends Comparable<E>> Pair<E, E> findMinAndMax(List<E> l){
        return findMinAndMax(l, E::compareTo);
    }

}
