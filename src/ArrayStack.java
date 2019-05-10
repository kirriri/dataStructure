import utils.Stack;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>(10);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapaticy() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        res.append("Stack:");
        res.append("[");
        int size = array.getSize();
        for(int i = 0; i < size; i++) {
            res.append(array.get(i));
            if(i != size - 1) {
                res.append(",");
            }
        }
        res.append("] bottom => top");
        return res.toString();
    }
}
