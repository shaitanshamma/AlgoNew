package lesson6;

public class Node<T extends Comparable<? super T>> {

    private final T value;

    Node<T> leftChild;
    Node<T> rightChild;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean shouldBeLeft(T value) {
        return this.value.compareTo(value) > 0;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlySingleChild() {
//        return !isLeaf() && (leftChild != null || rightChild != null);
        return leftChild != null ^ rightChild != null;
    }
}
