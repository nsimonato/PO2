package Exercises.Eserciziario2;

import java.util.Iterator;
import java.util.Random;

public class Es2p7 {
/*
(a) Si scriva un wrapper della classe Random che si comporta come un singleton, facendo attenzione a riprodurre
ogni aspetto dell’originale.
*/
    public static class RandomSingleton{
        private static Random instance;

        public static Random getInstance(){
            if (instance == null)
                instance = new Random();
            return instance;
        }

        public void setSeed(int seed) {
            instance = new Random(seed);
        }

        public static int nextInt(){
            return getInstance().nextInt();
        }

        public static double nextDouble(){
            return getInstance().nextDouble();
        }
    }

    public static void main(String args[]){

        Random b = RandomSingleton.getInstance();
        b.nextInt();
    }
/*
(b) Si definisca una classe RandomIterator che implementa l’interfaccia java.util.Iterator<Integer> del
JDK e che si comporta come un iteratore su interi, generando un numero casuale ad ogni invocazione del
metodo next() anzich´e scorrendo una vera collection, fino ad esaurire la sequenza di lunghezza specificata in
costruzione. Si implementino opportunamente il costruttore ed i metodi richiesti dall’interfaccia.
*/
    public static class RandomIterator implements Iterator<Integer> {
    protected Random a = new Random();
    protected int i = 0, max = 0;

    public RandomIterator(int max){this.max = max;}

    @Override
    public boolean hasNext() {
        return i < max;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return a.nextInt();
        }
        return null;
    }
}
}
