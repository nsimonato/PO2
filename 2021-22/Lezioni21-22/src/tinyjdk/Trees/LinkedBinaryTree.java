package tinyjdk.Trees;

public class LinkedBinaryTree<T> implements GenericBinaryTree<T>{
    BinaryNode<T> root = null;
    int size = 0;

    LinkedBinaryTree(BinaryNode<T> root){
        this.root = root;
        ++size;
    }

    @Override
    public T root() {
        return root.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T node) {

    }

    @Override
    public void delete(T node) {

    }

    @Override
    public boolean contains(T value) {
        return root.left().getValue().equals(value) || root.right().getValue().equals(value) || new LinkedBinaryTree<>(root.left()).contains(value) || new LinkedBinaryTree<>(root.right()).contains(value);
    }

    @Override
    public T father(T node) {
        return null;
    }

    @Override
    public void transplant(BinaryNode<T> from, BinaryNode<T> to) {
        to = null;
        to = from;
        from = null;
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
