package tinyjdk;

public class ReverseLinkedList<T> extends LinkedList<T>{
    @Override
    public void add(T e) { //The new element is added on the head of the list
        Node<T> n = new Node<>(e, null); //The Node is created
        if (head != null) { //The Node is directly inserted in the tail, if the List is not empty
            n.next = head;
            head = n;
        }
        else
            head = tail = n; //If the List is empty, the head and the tail point to the same, new, Node
        ++len;
    }
}
