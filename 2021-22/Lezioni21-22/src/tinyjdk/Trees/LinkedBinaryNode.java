package tinyjdk.Trees;

public class LinkedBinaryNode<T> implements BinaryNode<T> {
    T value;
    LinkedBinaryNode<T> left = null, right = null;

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public BinaryNode<T> left() {
        return left;
    }

    @Override
    public BinaryNode<T> right() {
        return right;
    }
}
