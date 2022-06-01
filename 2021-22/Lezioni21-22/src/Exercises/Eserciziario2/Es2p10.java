package Exercises.Eserciziario2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Es2p10 {
/*
Si implementi in Java una sottoclasse generica di ArrayList di nome FancyArrayList che estende le funzionalit`a
della superclasse con un iteratore pi`u versatile. Il nuovo iteratore deve essere in grado di andare sia avanti
che indietro secondo un valore di incremento intero non nullo; e di processare gli elementi che incontra durante
l’attraversamento applicando una funzione di trasformazione.
*/
/*
(a) Si definisca una interfaccia funzionale di nome Function parametrica sia sul tipo del dominio che sul tipo
del codominio, equivalente a quella definita dal JDK 8+ nel package java.util.function.
*/
    public interface Function<A,B>{
        B apply(A in);
    }
/*
(b) Si definisca la sottoclasse FancyArrayList parametrica su un tipo E e si implementi un metodo pubblico avente
firma Iterator<E> iterator(int step, Function<E, E> f) che crea un iteratore con le caratteristiche
accennate sopra tramite una classe anonima. Più precisamente:
• quando il valore del parametro step `e positivo, l’iteratore parte dall’inizio della collezione e va avanti
incrementando il cursore di step posizioni ad ogni passo; quando invece step `e negativo, l’iteratore parte
dalla fine della collezione e va indietro decrementando il cursore;
• ad ogni passo l’iteratore applica la funzione di trasformazione f all’elemento da restituire.

/*
(c) Si aggiungano a FancyArrayList i seguenti metodi pubblici, badando ad implementarli in funzione del metodo
iterator(int, Function<E, E>) realizzato per l’esercizio precedente, senza replicazioni di codice. Per
ciascuno si specifichi inoltre se `e un override oppure no, utilizzando opportunamente l’annotazione @Override.
i. Si implementi il metodo avente firma Iterator<E> iterator() che produce un iteratore convenzionale
che procede in avanti di una posizione alla volta.
ii. Si implementi il metodo avente firma Iterator<E> backwardIterator() che produce un iteratore rovescio
che procede indietro di una posizione alla volta.


(d) Si rifattorizzi il metodo iterator(int, Function<E, E>) realizzato per il punto (b) in modo che non usi
una classe anonima, ma una nuova classe innestata statica e parametrica di nome FancyIterator. Si presti
particolare attenzione all’uso dei generics ed al passaggio esplicito della enclosing instance al costruttore.
*/
    
    public class FancyArrayList<E> extends ArrayList<E>{
        /*Iterator<E> iterator(int step, Function<E, E> f){
            final int start[] = new int[1];
            start[0] = (step >= 0) ? 0 : size();
            return new Iterator<E>() {
                @Override
                public boolean hasNext() {
                    return start[0] >= 0 && start[0] < size();
                }

                @Override
                public E next() {
                    if(hasNext()){
                        E element = get(start[0]);
                        start[0] += step;
                        return f.apply(element);
                    }                    
                    return null;
                }
            };
        }*/

        @Override
        public Iterator<E> iterator(){
            return iterator(1, (x) -> x);
        }

        public Iterator<E> backwardIterator(){
            return iterator(-1, (x) -> x);
        }

        public Iterator<E> iterator(int step, Function<E,E> f){
            return new FancyIterator<E>(this,step, f);
        }
        
        public static class FancyIterator<T> implements Iterator<T> {
            protected List<T> l;
            protected int start, step;
            protected Function<T,T> f;
            FancyIterator(List<T> l, int step, Function<T,T> f){
                this.l = l;
                this.step = step;
                this.f = f;
            }
            
            @Override
            public boolean hasNext(){
                return start >= 0 && start < l.size();
            }

            @Override
            public T next() {
                if(hasNext()){
                    T elem = l.get(start);
                    start += step;
                    return f.apply(elem);
                }
                return null;
            }
        }
    }

}
