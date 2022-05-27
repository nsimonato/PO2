package Exercises.Eserciziario2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class Es2p2 {

    /*
    * (a) Si definisca una interfaccia funzionale simile a java.util.BiFunction che rappresenta funzioni binarie,
parametrica sui 2 tipi degli argomenti e sul tipo di ritorno.*/
    public interface BiFunction<I1,I2, O>{
        O apply(I1 a, I2 b);
    }

    /*
(b) Si definisca un tipo per la coppia eterogenea immutabile, ovvero una classe Pair parametrica su 2 tipi distinti
che rappresentano rispettivamente il tipo del primo e del secondo elemento della coppia.*/
    public static class Pair<A,B>{
        public final A f;
        public final B s;

        Pair(A f, B s){
            this.f = f;
            this.s = s;
        }
    }
    /*
(c) Si definisca un tipo per la tripla eterogenea immutabile, ovvero una sottoclasse di Pair di nome Triple,
parametrica su 3 tipi distinti che rappresentano i tipi dei 3 elementi.*/
    public static class Triple<A,B,C> extends Pair<A,B>{
        public final C t;
        Triple(A f, B s, C t) {
            super(f, s);
            this.t = t;
        }
    }

    /*
(d) Si definisca un metodo statico evalIterator generico su 3 tipi A, B e C che, dato un iteratore su coppie A ∗ B
ed una funzione binaria A ∗ B → C, produce un nuovo iteratore su triple A ∗ B ∗ C che si comporta come un
wrapper di quello in input. L’iteratore in output applica la funzione binaria ad ogni coppia di elementi letti
dall’iteratore in input e produce una tripla con i due valori appena letti e passati alla funzione assieme al
risultato di quest’ultima. Si utilizzino i tipi Pair, Triple e BiFunction definiti nei punti precedenti.*/
    public static <A,B,C> Iterator<Triple<A,B,C>> evalIterator(Iterator<Pair<A,B>> it, BiFunction<A,B,C> f){
        return new Iterator<Triple<A, B, C>>() {
            Iterator<Pair<A,B>> ita = it;
            BiFunction<A,B,C> fa = f;
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Triple<A, B, C> next() {
                Pair<A,B> n = it.next();
                C c = f.apply(n.f, n.s);
                return new Triple<>(n.f,n.s,c);
            }
        };
    }
    /*
(e) Si implementi un classe FiboSequence le cui istanze rappresentano sequenze contigue di numeri di Fibonacci
di lunghezza data in costruzione. Tali istanze devono essere iterabili tramite il costrutto for-each di Java,
devono pertanto implementare l’interfaccia parametrica del JDK java.util.Iterable<T>. Ad esempio, il
seguente codice deve compilare e stampare i primi 100 numeri di Fibonacci:
for (int n : new FiboSequence(100)) {
System.out.println(n);
}
Requisito obbligatorio `e che i numeri di Fibonacci generati dall’iteratore3
sottostiano ad un meccanismo di
caching che ne allevia il costo computazionale memorizzando il risultato di ogni passo di ricorsione, in modo
che ogni computazione successiva con il medesimo input costi solamente un accesso in lettura alla cache.*/
    public static class FiboSequence implements Iterable<Integer>{
        final int M;

        public FiboSequence(int M) {
            this.M = M;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                int f = 0;
                int s = 1;
                int c, i = 0;
                final int max = M;
                @Override
                public boolean hasNext() {
                    return i < max;
                }

                @Override
                public Integer next() {
                    if(i > max)
                        return null;
                    else{
                        c = f + s;
                        f = s;
                        s = c;
                        ++i;
                        return c;
                    }
                }
            };
        }
    }
    /*
(f) Si scriva il codice de-zuccherato dello statement for-each di cui al punto precedente.
*/
    public static void f(){
        /*for (int n : new FiboSequence(100)) {
            System.out.println(n);
        }*/
        Iterator<Integer> it = new FiboSequence(100).iterator();
        for(int n = 0; it.hasNext(); n = it.next()){
            System.out.println(n);
        }
    }
    /*
   (g) Si riscriva la classe FiboSequence in modo che la cache sia condivisa tra molteplici istanze.*/
    public static class StaticFiboSequence implements Iterable<Integer> {
        static int max, a = 0, b = 1, c;
        StaticFiboSequence(int m){
            max = m;
        }
        @NotNull
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                int i;
                @Override
                public boolean hasNext() {
                    return i < StaticFiboSequence.max;
                }

                @Override
                public Integer next() {
                    if( i < max){
                        StaticFiboSequence.c = StaticFiboSequence.a + StaticFiboSequence.b;
                        StaticFiboSequence.a = StaticFiboSequence.b;
                        StaticFiboSequence.b = StaticFiboSequence.c;
                        ++i;
                        return StaticFiboSequence.c;
                    }
                    else
                        return null;
                }
            };
        }
    }

        /*
(h) Si consideri una funzione multiFact() che data una Collection<Integer> produce una Collection<FactThread>,
in modo che per ogni intero in input viene eseguito lo spawn di un nuovo thread che ne computa il fattoriale
e ne conserva il risultato.
i. Si implementi la classe FactThread opportunamente, in modo che estenda java.lang.Thread ed incapsuli
l’accesso al risultato della computazione del fattoriale.
ii. Si implementi la funzione multiFact().
iii. Si scriva un pezzo di codice che testa la funzione multiFact() attendendo la terminazione di ciascun
thread e stampando i risultati di ciascuno.
*/
    public static class FactThread extends Thread{
        int n;
        int result = 1;

        public FactThread(int n){
            this.n = n;
            this.start();
        }

        @Override
        public synchronized void run() {
            while(n > 1){
                result *= n;
                --n;
            }
        }
    }

    public static Collection<FactThread> multiFact(Collection<Integer> c){
        Collection<FactThread> f = new ArrayList<>();
        for(int n: c){
            FactThread t = new FactThread(n);
            f.add(t);
        }
        return f;
    }

    public static void main(String args[]) throws InterruptedException {
        Random r = new Random();
        final int max = 100;
        Collection<Integer> c = new ArrayList<>();
        for (int i = 0; i < max; ++i){ c.add(r.nextInt(max));} //Riempio la collection;
        Collection<FactThread> ff = multiFact(c);

        for(FactThread t: ff){
            t.run();
        }

        for(FactThread t: ff){
            t.join();
        }
    }
}
