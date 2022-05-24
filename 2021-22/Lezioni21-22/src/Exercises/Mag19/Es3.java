package Exercises.Mag19;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Es3 {

    public static class FactThread extends Thread{
        public int input, result;
        FactThread(int n){
            input = n;
        }

        private int factorial(int n){
            if(n == 0) return 1;
            else return n * factorial(n - 1);
        }

        @Override
        public void run(){
            result = factorial(input);
        }

    }

    public static Collection<FactThread> multiFact(Collection<Integer> c) throws InterruptedException {
        Collection<FactThread> result = new ArrayList<>();
        for(int n : c){
            FactThread f = new FactThread(n);
            result.add(f);
            f.start();
        }
        return result;
    }

    public static void main(String args[]) throws InterruptedException {
        Random rand = new Random(23);
        Collection<Integer> nums = new ArrayList<>();
        for(int i = 0; i < 100; ++i){
            nums.add(rand.nextInt(20));
        }

        Collection<FactThread> threads = multiFact(nums);

        for(FactThread f: threads){
            f.join();
            System.out.println("[Thread " + f.getId() + "]: " + f.input + " -> " + f.result);
        }

    }
}
