package tinyjdk;

public class LinkedList<T> implements List<T> {

    protected Node<T> head = null, tail = null; //In order to implement the operation in O(1), a pointer to the tail is stored
    protected int len = 0;

    protected static class Node<X> {
        public X data;
        public Node<X> next;

        protected Node(X data, Node<X> next) { //The constructor initializes the fields of the node, for security reasons (the programmer could forget to do it)
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void add(T e) {
        Node<T> n = new Node<>(e, null); //The Node is created
        if (tail != null) { //The Node is directly inserted in the tail, if the List is not empty
            tail.next = n;
            tail = n;
        }
        else
            head = tail = n; //If the List is empty, the head and the tail point to the same, new, Node
        ++len;
    }

    // TODO: da testare
    @Override
    public void remove(T e) throws NotFoundException {
        Node<T> prev = null, n = head;
        while (n != null) {
            if (n.data.equals(e)) {
                if (prev != null)
                    prev.next = n.next;
                else
                    head = n.next;
                if (n.next == null)
                    tail = prev;
                return;
            }
            prev = n;
            n = n.next;
        }
        throw new NotFoundException();
    }

    @Override
    public void clear() {
        head = tail = null; //Setting the pointer to null makes the Garbage Collector deallocate all the memory they pointed to
        len = 0;
    }

    @Override
    public int size() {
        return len;
    } //Returns the size of the List, stored in "len"

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> n = head; //Stores the current node

            @Override
            public boolean hasNext() {
                return n.next != null;
            }

            @Override
            public T next() {
                T r = n.data; //Saves the value of the current node
                n = n.next; //Sets the current element as the next one
                return r;
            }
        };
    }

    protected Node<T> nodeAt(int pos) { //This method is not defined by the List interface, is added to simplify the following code
        assert (pos < size());
        Node<T> n = head;
        for (; pos > 0; --pos) //the argument "pos" is decremented until it reaches 0
            n = n.next;
        return n; //then, the element is returned
    }

    @Override
    public T get(int pos) {
        return nodeAt(pos).data;
    } //Returns the value of the node at position "pos"

    @Override
    public void set(int pos, T e) {
        nodeAt(pos).data = e;
    } //Sets the value of the Node at position "pos"

    @Override
    public int indexOf(T e) throws NotFoundException {
        Node<T> n = head;
        for (int pos = 0; n != null; ++pos) {
            if (n.data.equals(e)) {
                return pos;
            }
            n = n.next;
        }
        throw new NotFoundException(); //This line is reached only if no matching element is found
    }
}
