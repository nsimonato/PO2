package Exercises.Set18;

import java.util.Collection;
import java.util.Iterator;

public class Comparator_Es2 {
    public static <A extends Comparable<B>,B extends Comparable<A>> int compareMany(Collection<A> a, Collection<B> b){
        int result = a.size() - b.size();
        Iterator<A> it_a = a.iterator();
        Iterator<B> it_b = b.iterator();
        while(it_a.hasNext() && it_b.hasNext()){
            A inst_a = it_a.next();
            B inst_b = it_b.next();
            result += inst_a.compareTo(inst_b);
        }
        return 0;
    }
}
