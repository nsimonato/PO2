package Exercises.Set18;

import java.util.*;
import java.util.function.Function;

public class ArrayList_Es3 {

    @FunctionalInterface
    interface Predicate<T> extends Function<T,Boolean>{}

    interface Either<T>{
        T onSuccess(T in);
        void onFailure(T in) throws Exception;
    }

    public static class SkippableArrayList<E> extends ArrayList<E>{
        Iterator<E> iterator(Predicate<E> p, Either<E> f){
            return new Iterator<E>() {
                int current = 0;
                @Override
                public boolean hasNext() {
                    return current < size();
                }

                @Override
                public E next() {
                    E i = get(current);
                    if(p.apply(i))
                        i = f.onSuccess(i);
                    else{
                        try{
                            f.onFailure(i);
                        }catch(Exception e){
                            e.fillInStackTrace();
                        }
                    }
                    return i;
                }
            };
        }
    }

    public static void main(String args[]){
        ArrayList<Integer> l = new ArrayList<>();
        SkippableArrayList<Integer> s = new SkippableArrayList<>();
        Random rand = new Random();

        for(int i = 0; i < 100; ++i){
            s.add(rand.nextInt(11));
        }

        Iterator<Integer> it = s.iterator((x) -> x > 5, new Either<Integer>() {
            @Override
            public Integer onSuccess(Integer in) {
                return in + 1;
            }

            @Override
            public void onFailure(Integer in) throws Exception {
                l.add(in);
            }
        });

    }
}
