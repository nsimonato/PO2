package Exercises.Eserciziario2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;

public class Es2p9 {
/*. Si implementi una sottoclasse generica di java.util.ArrayList di nome SkippableArrayList che estende la
superclasse con un iteratore in grado di discriminare gli elementi secondo un predicato booleano. Gli elementi che
soddisfano il predicato vengono processati da una certa funzione di trasformazione; gli altri vengono passati ad
una seconda callback (non una funzione di trasformazione).
*/
/*
(a) Si definisca una interfaccia funzionale di nome Predicate specializzando l’interfaccia generica java.util.Function
del JDK in modo che il tipo del parametro dell metodo apply sia generico ed il tipo di ritorno sia Boolean.
*/
    public interface Predicate<T> extends Function<T,Boolean> {}
/*
(b) Si definisca una interfaccia di nome Either parametrica su un tipo T che include due metodi di nome diverso:
il primo metodo, onSuccess, `e una funzione di trasformazione che viene chiamata dall’iteratore quando il
predicato ha successo; il secondo metodo, onFailure, viene invocato invece quando il predicato fallisce, prende
un argomento di tipo T e non produce alcun risultato, tuttavia pu`o lanciare una eccezione di tipo Exception.
*/
    public interface Either<T>{
        T onSuccess(T arg);
        void onFailure(T arg) throws Exception;
    }
/*
(c) Si definisca la sottoclasse SkippableArrayList parametrica su un tipo E e si implementi un metodo pubblico
avente firma Iterator<E> iterator(Predicate<E> p, Either<E> f) che crea un iteratore con le caratteristiche accennate sopra.
In particolare:
• l’iteratore parte sempre dall’inizio della collezione ed arriva alla fine, andando avanti di un elemento alla
volta normalmente;
• ad ogni passo l’iteratore applica il predicato p all’elemento corrente: se il predicato p viene soddisfatto
allora viene invocato il metodo onSuccess di f e passato l’elemento corrente come argomento; altrimenti
viene invocato il metodo onFailure e passato l’elemento corrente come argomento a quest’ultimo;
• l’invocazione di onFailure deve essere racchiusa dentro un blocco che assicura il trapping delle eccezioni
- in altre parole, una eccezione proveniente dall’invocazione di onFailure non deve interrompere lo
scorrimento della collection da parte dell’iteratore;
• quando viene invocato onSuccess, il suo risultato viene restituito come elemento corrente dall’iteratore;
• quando viene invocato onFailure, l’iteratore ritorna l’elemento originale che ha fatto fallire il predicato.
*/
    public static class SkippableArrayList<T> extends ArrayList<T>{

        Iterator<T> iterator(Predicate<T> p, Either<T> e){
            return new Iterator<T>() {
                Iterator<T> original_it = iterator();
                Predicate<T> pred = p;
                Either<T> callback = e;
                @Override
                public boolean hasNext() {
                    return original_it.hasNext();
                }

                @Override
                public T next() {
                    if(!hasNext())
                        return null;
                    T n = original_it.next();
                    if(p.apply(n))
                        return e.onSuccess(n);
                    else{
                        try {
                            e.onFailure(n);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        return n;
                    }
                }
            };
        }
    }
/*
(d) Si scriva un esempio di codice main che:
• costruisce una ArrayList di interi vuota;
• costruisce una SkippableArrayList di interi;
• popola quest’ultima con numeri casuali compresi tra 0 e 10, inclusi gli estremi7
;
• invocando solamente una volta il metodo iterator(Predicate<E>, Either<E>) della SkippableArrayList
con gli argomenti opportuni, somma 1 a tutti gli elementi maggiori di 5 e appende all’ArrayList quelli
minori o uguali a 5.
*/
    public static void main(String args[]){
        ArrayList<Integer> a = new ArrayList<>();
        SkippableArrayList<Integer> b = new SkippableArrayList<>();
        Random r = new Random();

        for(int i = 0; i < 100; ++i){
            b.add(r.nextInt(11));
        }

        Iterator<Integer> it = b.iterator((Integer x) -> x > 5, new Either<Integer>() {
            @Override
            public Integer onSuccess(Integer arg) {
                return arg + 5;
            }

            @Override
            public void onFailure(Integer arg) throws Exception {
                a.add(arg);
            }
        });
    }
}
