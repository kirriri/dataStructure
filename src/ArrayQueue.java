import utils.Queue;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSzie() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue:size = %d , capacity = %d\n", array.getSize(), array.getCapacity()));
        res.append("[");
        for(int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize() -1) {
                res.append(",");
            }
        }
        res.append("] <= tail");
        return res.toString();
    }
}
