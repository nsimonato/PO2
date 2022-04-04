package tinyjdk.Interfaces;

import tinyjdk.NotFoundException;
import tinyjdk.Foundations.Pair;

public interface Map<K,V> extends Iterable<Pair<K,V>> {

    public Iterator<Pair<K, V>> iterator();

    public V get(K key) throws NotFoundException;

    public V put(K key, V value) throws NotFoundException;

    public void clear();

    public boolean containsKey(K key) throws NotFoundException;

    public boolean containsValue(V value);

    public void remove(K key) throws NotFoundException;
}
/*
* Map is a collection of unique instances of Pair<K,V>. The order of insertion is mantained
* */
