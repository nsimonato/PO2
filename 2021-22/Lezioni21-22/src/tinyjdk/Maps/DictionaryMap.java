package tinyjdk.Maps;


import tinyjdk.Interfaces.Iterator;
import tinyjdk.Interfaces.List;
import tinyjdk.Interfaces.Map;
import tinyjdk.Lists.ArrayList;
import tinyjdk.NotFoundException;
import tinyjdk.Foundations.Pair;

public class DictionaryMap<K extends Comparable<? super K>,V> implements Map<K,V> {

    List<Pair<K,V>> l = new ArrayList<>();

    private int find(K key) throws NotFoundException {
        return 0;
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return l.iterator();
    }

    @Override
    public V get(K key) throws NotFoundException {
        return l.get(find(key)).getSecond();
    }

    @Override
    public V put(K key, V value) throws NotFoundException {
        V ret;
        if(this.get(key) == null){
            l.add(new Pair<K,V>(key,value));
            ret = value;
        }
        else{
            ret = l.get(find(key)).getSecond();
            l.get(find(key)).setSecond(value);
            //Collections.sort(l); facciamo finta che funzioni, sticazzi
        }
        return ret;
    }

    @Override
    public void clear() {
        l = new ArrayList<>();
    }

    @Override
    public boolean containsKey(K key) throws NotFoundException {
        return find(key) >=0;
    }

    @Override
    public boolean containsValue(V value) {
        Iterator<Pair<K,V>> i = l.iterator();
        Pair<K,V> aux;
        while(i.hasNext()){
            aux = i.next();
            if(aux.getSecond().equals(value))
                return true;
        }
        return false;
    }

    @Override
    public void remove(K key) throws NotFoundException {

    }
}
