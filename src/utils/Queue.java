package utils;

public interface Queue<E> {
    int getSzie();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
