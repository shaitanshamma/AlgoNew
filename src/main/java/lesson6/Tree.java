package lesson6;

        import Utils.ICollection;


public interface Tree<E extends Comparable<? super E>> extends ICollection, Iterable<E> {

    enum TraverseMode{
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    boolean find(E value);

    boolean add(E value);

    boolean remove(E value);

    void display();

    boolean isBalanced(Node<E> node);

    void traverse(TraverseMode mode);
}
