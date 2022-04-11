package tinyjdk.Trees;

public interface GenericBinaryTree<T> {
    T root();
    int size();
    void insert(T node);
    void delete(T node);
    boolean contains(T value);
    T father(T node);
    void transplant(BinaryNode<T> from,BinaryNode<T> to);
    void preOrder();
    void inOrder();
    void postOrder();
}
