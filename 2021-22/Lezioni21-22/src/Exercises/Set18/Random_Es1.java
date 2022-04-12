package Exercises.Set18;

import java.util.*;

public class Random_Es1 {
        //Non è consentito l'overloading per funzioni che differiscono solo per il tipo di ritorno
        /*public Random() { }
        public Random(int seed) {  }
        public boolean next() { return false; }
        public int next() { return 0; }
        public double next() { return 0.0; }*/

    public class RandomSingleton extends Random{
        private static Random instance;

        public RandomSingleton(){
            instance = new Random();
        }

        public RandomSingleton(int seed){
            instance = new Random(seed);
        }

        public Random getInstance(){
            if(instance == null)
                instance = new RandomSingleton();

            return instance;
        }

    }

    public class RandomIterator implements Iterator<Integer> {

        Random rand = new Random();
        int size;

        RandomIterator(int size){
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public Integer next() {
            --size;
            return rand.nextInt();
        }
    }




}
