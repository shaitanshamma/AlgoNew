package lesson3.stack;


import Utils.ICollection;

public interface Stack<E> extends ICollection {

    void push(E value);

    E pop();

    E peek();

}
