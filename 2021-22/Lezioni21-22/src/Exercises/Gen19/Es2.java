package Exercises.Gen19;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Es2 {
    public interface Pool<T, R> {
        void add(T x); // popola la pool con un nuovo elemento
        R acquire() throws InterruptedException; // acquisisce una risorsa
        void release(R x); // rilascia una risorsa e la rimette nella pool
    }

    public interface BasicPool<T> extends Pool<T,T>{

    }

    public class SimplePool<T> implements BasicPool<T>{
        protected LinkedBlockingQueue<T> q = new LinkedBlockingQueue<>();

        @Override
        public void add(T x) {
            q.add(x);
        }

        @Override
        public T acquire() throws InterruptedException {
            T e = q.peek();
            q.take();
            return e;
        }

        @Override
        public void release(T x) {
            add(x);
        }
    }

    public class Resource<T> {
        T peek;
        LinkedBlockingQueue<T> q;
        int reference = 0;

        public Resource(T peek, LinkedBlockingQueue<T> q) {
            this.peek = peek;
            this.q = q;
            reference++;
        }

        void release() throws Throwable {
            q.add(peek);
            --reference;
            if(reference == 0)
                this.finalize();
        }
    }

    public class AutoPool<T> implements Pool<T, Resource>{
        protected LinkedBlockingQueue<T> q = new LinkedBlockingQueue<>();

        @Override
        public void add(T x) {
            q.add(x);
        }

        @Override
        public Resource acquire() throws InterruptedException {
            Resource e = new Resource(q.peek(), q);
            q.take();
            return e;
        }

        @Override
        public void release(Resource x) {
            try{
                x.release();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

        }
    }
}
