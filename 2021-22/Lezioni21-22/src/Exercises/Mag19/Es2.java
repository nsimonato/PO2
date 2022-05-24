package Exercises.Mag19;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Es2 {
    public static class FiboSequence implements Iterable<Integer> {
        int max;
        public FiboSequence(int max){
            this.max = max;
        }
        @NotNull
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                int i = 0, a = 0, b = 1, c;
                int stop = max;
                @Override
                public boolean hasNext() {
                    return i < stop;
                }

                @Override
                public Integer next() {
                    if(hasNext()){
                        c = a + b;
                        a = b;
                        b = c;
                        ++i;
                    }
                    return c;
                }
            };
        }
    }

    private void loop(){
        FiboSequence f = new FiboSequence(100);
        Iterator<Integer> it = f.iterator();
        while(it.hasNext()){
            int n = it.next();
            System.out.println(n);
        }
    }

    public static class SFiboSequence implements Iterable<Integer>{
        int max;
        static int i = 0, a = 0, b = 1, c;
        public SFiboSequence(int max){
            this.max = max;
        }
        @NotNull
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {

                int stop = max;
                @Override
                public boolean hasNext() {
                    return i < stop;
                }

                @Override
                public Integer next() {
                    if(hasNext()){
                        c = a + b;
                        a = b;
                        b = c;
                        ++i;
                    }
                    return c;
                }
            };
        }
    }


}
