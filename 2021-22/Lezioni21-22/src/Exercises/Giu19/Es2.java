package Exercises.Giu19;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Es2 {

    static class Node<T> implements  Iterable<T>{
        T elem;
        Node<T> left, right;

        @NotNull
        @Override
        public Iterator<T> iterator() {
            Node<T> aux = this;
            return new Iterator<T>() {
                Node<T> current = aux;
                Stack<Node<T>> next = new Stack<Node<T>>();
                @Override
                public boolean hasNext() {
                    return !next.isEmpty();
                }

                @Override
                public T next() {
                    T a = current.elem;
                    next.push(current.left);
                    next.push(current.right);
                    current = next.pop();
                    return a;
                }
            };
        }
    }
}
