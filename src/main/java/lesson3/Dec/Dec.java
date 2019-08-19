package lesson3.Dec;

import Utils.ICollection;

public interface Dec<E> extends ICollection {

    boolean insertRight(E value);

    boolean insertLeft(E value);

    E removeRight();

    E removeLeft();

    E peekLeft();

    E peekRight();



}
