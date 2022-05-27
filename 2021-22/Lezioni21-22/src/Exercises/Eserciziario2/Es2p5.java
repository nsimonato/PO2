package Exercises.Eserciziario2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;

public class Es2p5 {


/*
(a)
i. Si definisca una interfaccia funzionale simile a quella definita in java.util.Function parametrica sia
sul tipo dell’argomento che sul tipo di ritorno.
ii. Si definisca un metodo statico mapIterator generico su due tipi A e B che, dato un iteratore su A ed
una funzione da A a B, produce un nuovo iteratore che si comporta come un wrapper di quello in input
applicando la funzione ad ogni elemento iterato. Si utilizzi il tipo funzione definito nel punto precedente.
*/

    public interface MFunction<A,B>{
        B apply(A input);
    }

    public static <A,B> Iterator<B> mapIterator(Iterator<A> ita, Function<A,B> ff){
        return new Iterator<B>() {
            Iterator<A> it = ita;
            Function<A,B> f = ff;
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public B next() {
                return f.apply(it.next());
            }
        };
    }

    /*
(b)
i. Si definisca un tipo per la coppia eterogenea, ovvero una classe Pair parametrica su due tipi distinti A e
B che rappresentano rispettivamente il tipo del primo e del secondo elemento della coppia.
ii. Si definisca un metodo statico pairIterator generico su un tipo A che, dato un iteratore su A, ritorna
un nuovo iteratore che itera su coppie di elementi, prendendone due a due dall’iteratore passato come
argomento. Quando non sono disponibili 2 elementi, si consideri la sequenza come terminata - in altre
parole, una sequenza di lunghezza dispari viene trattata come una sequenza di coppie fino al penultimo
elemento, scartando l’ultimo. Si utilizzi il tipo Pair definito nel punto precedente.
*/

    public static class Pair<A,B>{
        A f;
        B s;
        Pair(A a, B b){
            f = a;
            s = b;
        }
    }

    public static <A> Iterator<Pair<A,A>> pairIterator(Iterator<A> ita){
        return new Iterator<Pair<A, A>>() {
            Iterator<A> it = ita;
            A a = it.next(),b = it.next();
            @Override
            public boolean hasNext() {
                return a != null && b!=null;
            }

            @Override
            public Pair<A, A> next() {
                a = it.next();
                b = it.next();
                if(hasNext())
                    return new Pair(a,b);
                else
                    return null;
            }
        };
    }

/*
(c) Si scriva un blocco di codice Java che utilizza i metodi di cui sopra per trasformare un iteratore di cateti in
un iteratore di ipotenuse che applica il teorema di pitagora in tempo reale. In particolare, si scriva un blocco
di codice che:

1. crea una collection iterabile a vostra scelta e la popola con numeri interi casuali usando la classe Random
del JDK5;

2. produce un iteratore su coppie di interi, avente tipo Iterator<Pair<Integer, Integer>>, passando
l’iteratore originale della collection come argomento al metodo pairIterator definito nell’esercizio precedente;

3. trasforma l’iteratore su coppie di interi appena prodotto in un altro iteratore che itera su Double chiamando mapIterator con una callback opportunamente definita. Tale callback calcola l’ipotenusa di un
triangolo rettangolo data una coppia di cateti. Si badi che i cateti sono interi e le ipotenuse sono double.

*/

    public static void main(String args[]){
        Collection<Integer> c = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < 100; ++i)
            c.add(rand.nextInt(55));

        Iterator<Integer> it_c = c.iterator();
        Iterator<Pair<Integer,Integer>> it_pp = pairIterator(it_c);
        Iterator<Double> it_ip = mapIterator(it_pp, (Pair<Integer,Integer> x) -> Math.sqrt(x.f*x.f + x.s*x.s));
    }
}
