package tinyjdk;

public class SimpleStack<E> implements Stack<E> {

    List<E> l = new ReverseLinkedList<>();

    @Override
    public boolean empty() {
        return l.size() == 0;
    }

    @Override
    public void push(E element) {
        l.add(element);
    }

    @Override
    public E pop() throws NotFoundException {
        E result = l.get(0);
        l.remove(result);
        return result;
    }

    @Override
    public E peek() {
        return l.get(0);
    }
}
