package tinyjdk.Trees;

public interface BinaryNode<T> {
    T getValue();
    BinaryNode<T> left();
    BinaryNode<T> right();
}
