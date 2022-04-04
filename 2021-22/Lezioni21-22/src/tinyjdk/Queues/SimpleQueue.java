package tinyjdk.Queues;

import tinyjdk.Interfaces.List;
import tinyjdk.Interfaces.Queue;
import tinyjdk.Lists.ReverseLinkedList;
import tinyjdk.NotFoundException;

public class SimpleQueue<T> implements Queue<T> {

    List<T> l = new ReverseLinkedList<>();

    @Override
    public void add(T t) {
        l.add(t);
    }

    @Override
    public T peek() throws NotFoundException {
        return l.get(l.size());
    }

    @Override
    public T remove() throws NotFoundException {
        T del = l.get(l.size());
        l.remove(del);
        return del;
    }
}
