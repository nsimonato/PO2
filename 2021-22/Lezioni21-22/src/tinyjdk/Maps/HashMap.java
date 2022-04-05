package tinyjdk.Maps;
import tinyjdk.Foundations.Pair;
import tinyjdk.Interfaces.Iterator;
import tinyjdk.Interfaces.List;
import tinyjdk.Interfaces.Map;
import tinyjdk.Lists.ArrayList;
import tinyjdk.NotFoundException;

public class HashMap<K,V> implements Map<K,V> {

    List<Pair<K,V>> l = new ArrayList<Pair<K, V>>();

    private int hash(K key){
        return 0;
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return l.iterator();
    }

    @Override
    public V get(K key) throws NotFoundException {
        return l.get(hash(key)).getSecond();
    }

    @Override
    public V put(K key, V value) throws NotFoundException {
        V result = l.get(hash(key)).getSecond();
        l.set(hash(key), new Pair<K,V>(key,value));
        return result;
    }

    @Override
    public void clear() {
        l = new ArrayList<>();
    }

    @Override
    public boolean containsKey(K key) throws NotFoundException {
        return l.get(hash(key)) != null;
    }

    public boolean containsValue(K key, V value) {
        return l.get(hash(key)).getSecond().equals(value);
    }

    @Override
    public void remove(K key) throws NotFoundException {
        l.set(hash(key), null);
    }
}
