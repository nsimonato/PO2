package Exercises.Eserciziario2;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

public class Es2p8 {
/*
Si scriva un metodo statico e generico compareMany che, dati due parametri di tipo java.util.Collection
generici su due tipi differenti, confronti ogni elemento di tipo A della prima con il corrispettivo elemento di tipo
B della seconda. Il confronto tra elementi va implementato chiamando il metodo compareTo opportunamente;
qualsiasi elemento differente rende le collection differenti, cos`ı come una lunghezza diversa. Il risultato del metodo
compareMany `e di tipo int e deve rispettare la semantica del confronto a tre vie di Java, da reinterpretare in modo
ragionevole per il caso specifico del confronto tra container.
*/

    public static <A extends Comparable<B>,B extends Comparable<A>> int compareMany(@NotNull Collection<A> first, @NotNull Collection<B> second){
        if(first.size() - second.size() != 0)
            return first.size() - second.size();
        Iterator<A> a = first.iterator();
        Iterator<B> b = second.iterator();

        while(a.hasNext() && b.hasNext()){
            A fa = a.next();
            B sb = b.next();

            if(fa.compareTo(sb) != 0)
                return -1;
        }
        return 0;
    }
}
