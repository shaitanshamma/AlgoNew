package lesson3.Dec;

import java.util.Deque;

public class DecImpl<E> implements Dec<E> {

    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;

    public final E[] data;
    private int size;

    private int head;
    private int tail;

    public DecImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }


    @Override
    public boolean insertLeft(E value) {
        if (isFull())
        return false;
        if (head - 1 < 0)
            head = lastIndex()+1;
            data[--head] = value;
            size++;

        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == lastIndex()) {
            tail =DEFAULT_TAIL;
        }
            data[++tail] = value;
            size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty())
            return null;

        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        E value = data[head++];
        size--;
        return value;
    }

    @Override
    public E removeRight() {
        return data[--size];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size==data.length;
    }

    private int lastIndex() {
        return data.length - 1;
    }

    @Override
    public E peekLeft() {
        return isEmpty() ? null : data[head];
    }

    @Override
    public E peekRight() {
        return isEmpty() ? null : data[lastIndex()];
    }
}
