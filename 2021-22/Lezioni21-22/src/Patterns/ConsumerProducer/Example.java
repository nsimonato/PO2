package Patterns.ConsumerProducer;

import tinyjdk.Interfaces.List;
import tinyjdk.Lists.ArrayList;

import java.util.Random;

public class Example<T> {

    public static List<Integer> q = new ArrayList<>();

    public static Random rand = new Random();

    public static class ConcreteProducer<T extends Number> extends Thread implements Consumer<Integer>{

        @Override
        public void run(){
            while(true){
                if(q.size() == 0) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                consume(q.get(0));
            }
        }

        @Override
        public void consume(Integer data) {
            System.out.println("Consumed:" + data + " (size = "+ q.size() + ")");
        }
    }

    public static class ConcreteConsumer<T extends Number> extends Thread implements Producer<Integer> {

        @Override
        public void run(){
            while(true){
                q.add((Integer) produce());
            }
        }

        @Override
        public Integer produce() {
            return (Integer) rand.nextInt(100);
        }
    }


    public static void main(String args[]){
        ConcreteConsumer<Integer> c = new ConcreteConsumer<>();
        ConcreteProducer<Integer> p = new ConcreteProducer<>();

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
