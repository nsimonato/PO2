package tinyjdk.Trees;

import tinyjdk.Interfaces.Queue;
import tinyjdk.Queues.SimpleQueue;

import java.util.Iterator;
import java.util.Vector;

public class ArrayBinaryTree<T> implements GenericBinaryTree<T>{

    Vector<T> vector = new Vector<>();

    @Override
    public T root() {
        return vector.get(0);
    }

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public void insert(T node) {
        vector.add(node);
    }

    @Override
    public void delete(T node) {
        vector.remove(node);
    }

    @Override
    public boolean contains(T value) {
        Iterator<T> it = vector.iterator();
        T x = it.next();
        while(it.hasNext()){
            if(x.equals(value))
                return true;
        }
        return false;
    }

    @Override
    public T father(T node) {
        int v = vector.indexOf(node);
        return vector.get(Math.floorDiv(v - 1, 2));
    }

    @Override
    public void transplant(BinaryNode<T> from, BinaryNode<T> to) {

    }

    @Override
    public void preOrder() {
    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }
}
