package Exercises.Giu18;

import java.util.ArrayList;
import java.util.Iterator;

public class FancyArrayList<E> extends ArrayList<E> {

    public Iterator<E> iterator(int step, FunctionProva<E,E> f){
        return new Iterator<E>() {
            int pos = 0;

            @Override
            public boolean hasNext() {
                try{
                   E elem = (pos >= 0 ? get(pos + 1) : get(pos - 1));
                   return true;
                }catch(Exception e){
                    return false;
                }
            }

            @Override
            public E next() {
                E elem;
                if(step >= 0)
                    elem = get(pos);
                else
                    elem = get(size() - pos - 1);
                set(pos - 1,f.apply(elem));
                pos += step;
                return elem;
            }
        };
    }

    @Override
    public Iterator<E> iterator(){
        return iterator(1,(x)->x);
    }

    public Iterator<E> backwardIterator(){
        return iterator(-1,(x)->x);
    }

    private static class FancyIterator<T> implements Iterator<T>{

        int pos = 0, step;
        FunctionProva<T,T> f;
        ArrayList<T> l;

        public FancyIterator(int step, FunctionProva<T,T> f, ArrayList<T> l){
            this.step = step;
            this.f = f;
            this.l = l;
        }

        @Override
        public boolean hasNext() {
            try{
                T elem = (pos >= 0 ? l.get(pos + 1) : l.get(pos - 1));
                return true;
            }catch(Exception e){
                return false;
            }
        }

        @Override
        public T next() {
            T elem;
            if(step >= 0)
                elem = l.get(pos);
            else
                elem = l.get(l.size() - pos - 1);
            l.set(pos - 1,f.apply(elem));
            pos += step;
            return elem;
        }
    }
}
