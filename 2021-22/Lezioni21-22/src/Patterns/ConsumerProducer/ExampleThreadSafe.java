package Patterns.ConsumerProducer;

import tinyjdk.Interfaces.List;
import tinyjdk.Lists.ArrayList;
import tinyjdk.NotFoundException;

import java.util.Random;

public class ExampleThreadSafe {

    public static List<Integer> q = new ArrayList<>();

    public static class ConcreteConsumer<T extends Number> extends Thread implements Consumer<Integer>{

        @Override
        public void run(){
            while(true){
                synchronized (q){
                    if(q.size() == 0) {
                        try {
                            q.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    consume(q.get(0));
                    try {
                        q.remove(0);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        @Override
        public void consume(Integer data) {
            System.out.println("Consumed:" + data + " (size = "+ q.size() + ")");
        }
    }

    public static class ConcreteProducer<T extends Number> extends Thread implements Producer<Integer> {

        @Override
        public void run(){
            while(true){
                synchronized (q){
                    q.add((Integer) produce());
                    q.notify();
                }

            }
        }

        @Override
        public Integer produce() {
            return (Integer) new Random(954L).nextInt(100);
        }
    }


    public static void main(String args[]){
        Example.ConcreteConsumer<Integer> c = new Example.ConcreteConsumer<>();
        Example.ConcreteProducer<Integer> p = new Example.ConcreteProducer<>();

        p.start();
        c.start();

        try {
            c.join();
            p.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
