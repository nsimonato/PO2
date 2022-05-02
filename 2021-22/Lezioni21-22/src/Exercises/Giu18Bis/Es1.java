package Exercises.Giu18Bis;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Es1 {

    public static class FancyArrayList<T> extends ArrayList<T>{
        public Iterator<T> iterator(int step, Function<T,T> f){
            if(step == 0)
                return iterator();
            else{
                return new Iterator<>(){
                    int current = step > 0 ? 0 : size();
                    @Override
                    public boolean hasNext() {
                        return (current + step > 0) && (current + step < size());
                    }

                    @Override
                    public T next() {
                        T c = get(current);
                        current += step;
                        return f.apply(c);
                    }
                };
            }
        }

        @Override
        public Iterator<T> iterator(){
            return iterator(1, (T x) -> x);
        }

        public Iterator<T> backwardIterator(){
            return iterator(-1, (T x) -> x);
        }

        public static class FancyIterator<E> implements Iterator<E> {
            int step, current;
            Function<E,E> f;
            List<E> l;
            FancyIterator(int step, Function<E,E> f, List<E> l){
                this.step = step;
                this.f = f;
                this.l = l;
                current = step > 0 ? 0 : l.size();
            }

            @Override
            public boolean hasNext() {
                return (current + step > 0) && (current + step < l.size());
            }

            @Override
            public E next() {
                E c = l.get(current);
                current += step;
                return f.apply(c);
            }
        }

    }

    @FunctionalInterface
    public interface MyFunction<I,O>{
        O apply(I in);
    }
}
