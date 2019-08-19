package Utils;

public interface ICollection {

    boolean isEmpty();

    int size();

    default boolean isFull() {
        return false;
    }
}
