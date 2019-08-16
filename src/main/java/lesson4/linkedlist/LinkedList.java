package lesson4.linkedlist;


import Utils.ICollection;



public interface LinkedList<E> extends ICollection/*, Iterable*/ {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    void display();

    E getFirstValue();


    class Entry<T> {
        public final T value;
        public Entry<T> next;

        public Entry(T value) {
            this.value = value;
        }
    }

}
