package Exercises.Gen19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Es1 {
    @FunctionalInterface
    interface Function<O,I>{
        O apply(I input);
    }

    public static <A,B> Iterator<B> mapIterator(Iterator<A> it, Function<B,A> f){
        return new Iterator<B>() {
            Iterator<A> it_ = it;
            @Override
            public boolean hasNext() {
                return it_.hasNext();
            }

            @Override
            public B next() {
                return f.apply(it_.next());
            }
        };
    }

    public static class Pair<A,B>{
        final A first;
        final B second;
        Pair(A f, B s){
            first = f;
            second = s;
        }
    }

    public static <A> Iterator<Pair<A,A>> pairIterator(Iterator<A> it){
        return new Iterator<Pair<A, A>>() {
            Iterator<A> it_ = it;
            A f, s;
            boolean next;

            @Override
            public boolean hasNext() {
                return next;
            }

            @Override
            public Pair<A, A> next() {
                f = it_.next();
                s = it_.next();
                next = f != null && s != null;
                if(next)
                    return new Pair<>(f,s);
                else
                    return null;
            }
        };
    }

    public static Iterator<Double> convertIterator(){
        List<Integer> cateti = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < 100; ++i)
            cateti.add(r.nextInt());

        Iterator<Pair<Integer,Integer>> it_cat = pairIterator(cateti.iterator());

        return mapIterator(it_cat, (Pair<Integer,Integer> p) -> Math.sqrt(Math.pow(p.first, 2.) + Math.pow(p.second, 2.)));
    }
}
