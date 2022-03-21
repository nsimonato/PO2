package tinyjdk;

public class PairMap<K, V> implements Map<K, V> {
    private List<Pair<K, V>> l; //It is a good practice to keep the declaration of the field as a superclass, and to realize the binding with a subclass (subsumption)

    public PairMap() {
        l = new ArrayList<>();
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return l.iterator();
    } //Since l is a list, we can use its Iterator

    @Override
    public V get(K key) {
        Pair<K, V> p = find(key); //Since we define the method "find", we can use it to spare some code.
        if (p != null) return p.getSecond();
        return null; //This line is reached if the element searched is not present in the List
    }

    private Pair<K, V> find(K key) {
        Iterator<Pair<K, V>> it = this.iterator(); //This class implements the method iterator() so we can use it as our advantage
        while (it.hasNext()) {
            Pair<K, V> p = it.next();
            if (p.getFirst().equals(key))
                return p;
        }
        return null; //This line is reached if the element searched is not present in the List
    }

    @Override
    public V put(K key, V value) {
        Pair<K, V> p = find(key);
        if (p != null) { //If the key already exists, the value is updated
            V r = p.getSecond();
            p.setSecond(value);
            return r;
        }
        l.add(new Pair<>(key, value)); //If the key doesn't exist, a Pair is added.
        return null;
    }

    @Override
    public void clear() {
        l.clear();
    } //We can use the method defined by the List class, since we use a List to implement our PairMap

    @Override
    public boolean containsKey(K key) {
        return find(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        Iterator<Pair<K, V>> it = this.iterator();
        while (it.hasNext()) {
            Pair<K, V> p = it.next();
            if (p.getSecond().equals(value))
                return true;
        }
        return false;
    }

    @Override
    public void remove(K key) throws NotFoundException {
        l.remove(find(key));
    }
}
