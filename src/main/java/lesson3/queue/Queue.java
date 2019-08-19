package lesson3.queue;

import Utils.ICollection;


public interface Queue<E> extends ICollection {

    boolean insert(E value);

    E remove();

    E peek();

}
