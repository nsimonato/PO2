package tinyjdk;

public interface Map<K, V> extends Iterable<Pair<K, V>> {
    V get(K key);
    V put(K key, V value);
    void clear();
    boolean containsKey(K key);
    boolean containsValue(V value);
    void remove(K key) throws NotFoundException;
}

/*
* Map is the simple representation of the set of Pairs of Key and Values.
* The operations are implemented in O(1).
* Not a "Collection" subtype.
* */
