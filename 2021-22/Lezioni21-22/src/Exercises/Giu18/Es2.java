package Exercises.Giu18;

import org.jetbrains.annotations.NotNull;

import java.util.*;

class Pair<X,Y>{
    X first;
    Y second;
    Pair(X f, Y s){
        first = f;
        second = s;
    }
}

public class Es2<T extends Comparable<? super T>> {
    /*public Pair<T,T> findMinAndMax(List<T> l){
        T min = Collections.min(l);
        T max = Collections.max(l);
        return new Pair<>(min,max);
    }*/

    static <E> @NotNull Pair<E, E> findMinAndMax(List<E> l, Comparator<E> c){
        Iterator<E> it = l.iterator();
        E min = null;
        E max = null;
        while(it.hasNext()){
            E i = it.next();
            if(min == null || c.compare(i,min) < 0)
                min = i;
            if(max == null || c.compare(i,max) > 0)
                max = i;
        }
        return new Pair<>(min,max);
    }

    static <E extends Comparable<E>> Pair<E, E> findMinAndMax(List<E> l){
        Iterator<E> it = l.iterator();
        E min = null;
        E max = null;
        while(it.hasNext()){
            E i = it.next();
            if(min == null || i.compareTo(min) < 0)
                min = i;
            if(max == null || i.compareTo(max) > 0)
                max = i;
        }

        return new Pair<>(min,max);
    }

}
