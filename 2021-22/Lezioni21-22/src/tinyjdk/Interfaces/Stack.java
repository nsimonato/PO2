package tinyjdk.Interfaces;

import tinyjdk.NotFoundException;

public interface Stack<E> {
    boolean empty();
    void push(E element);
    E pop() throws NotFoundException;
    E peek();
}
