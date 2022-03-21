package tinyjdk;

public class DoubleLinkedList<T> implements List<T> {

    protected DNode<T> head = null, tail = null;
    protected int len = 0;

    private class DNode<X>{
        X data;
        DNode<X> prev = null, next = null;
        protected DNode(X data, DNode<X> prev, DNode<X> next) { //The constructor initializes the fields of the node, for security reasons (the programmer could forget to do it)
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public void add(T e) {
        DNode<T> n = new DNode<>(e, null, null);
        if(tail != null){
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        else
            head = tail = n;
        ++len;
    }

    //TODO: Da testare ed implementare diversi casi possibili.
    @Override
    public void remove(T e) throws NotFoundException {
        DNode<T> n = nodeAt(indexOf(e));
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    @Override
    public void clear() {
        head = tail = null;
        len = 0;
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            DNode<T> n = head;
            @Override
            public boolean hasNext() {
                return n.next != null;
            }

            @Override
            public T next() {
                if(n != null){
                    T res = n.data;
                    n = n.next;
                    return res;
                }
                return null;
            }
        };
    }

    private DNode<T> nodeAt(int pos){
        assert pos < size();
        DNode<T> res = head;
        while(pos > 0){
            res = res.next;
            --pos;
        }
        return res;
    }

    @Override
    public T get(int pos) { return nodeAt(pos).data; }

    @Override
    public void set(int pos, T e) { nodeAt(pos).data = e; }

    @Override
    public int indexOf(T e) throws NotFoundException {
        Iterator<T> it = this.iterator();
        T x;
        int i = 0;
        while(it.hasNext()){
            x = it.next();
            if(x.equals(e))
                return i;
            ++i;
        }
        throw new NotFoundException();
    }
}
