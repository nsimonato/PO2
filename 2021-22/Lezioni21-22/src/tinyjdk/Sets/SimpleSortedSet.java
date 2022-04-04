package tinyjdk.Sets;

import tinyjdk.Interfaces.Iterator;
import tinyjdk.Interfaces.SortedSet;
import tinyjdk.NotFoundException;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections; //Utility Class


public class SimpleSortedSet<T extends Comparable<? super T>> implements SortedSet<T> {
    private List<T> l = new ArrayList<>();

    @Override
    public void add(T e) {
        if (!contains(e)) { //The element is added only if it doesn't already belong to the Set
            l.add(e);
            Collections.sort(l); //The Set is sorted after each addition.
        }
    }

    @Override
    public void remove(T e) throws NotFoundException {

    }

    @Override
    public boolean contains(T e) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
