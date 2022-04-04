package tinyjdk;

public interface Queue<E> {
    void add(E e);
    /*Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.*/
    E	peek() throws NotFoundException;
    /*Retrieves, but does not remove, the head of this queue.*/
    E	remove() throws NotFoundException;
    /*Retrieves and removes the head of this queue.*/
}
