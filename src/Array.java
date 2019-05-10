public class Array<E> {
    private E[] data;
    private  int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity () {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(e, size);
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    //添加元素
    public  void add(E e, int where) {
        if(where < 0 || where > size)
            throw new IllegalArgumentException("AddLast failed. require where > 0 and where < size");
        if (size == data.length)
            resizeData(2 * data.length);
        for(int i = size - 1; i >= where; i--) {
            data[i+1] = data[i];
        }
        data[where] = e;
        size++;
    }
    //删除index索引
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. require index > 0 and index <= size");
        }
        E ret = data[index];
        for(int i = index + 1; i < size; i++) {
                data[i-1] = data[i];
                System.out.println(data[i]);
        }
        size--;
        data[size] = null;
        if(size == data.length/4 && data.length/2 != 0)
            resizeData(data.length/2);
        return ret;
    }
    public E removeFirst() {
        return remove(0);
    }
    public E removeLast() {
        return remove(size - 1);
    }
    //获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. require index > 0 and index <= size");
        }
        return data[index];
    }
    //获取最后一个
    public E getLast() {
        return get(size -1);
    }
    //获取第一个
    public E getFirst() {
        return get(0);
    }
    //设置index索引位置的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. require index > 0 and index <= size");
        }
        data[index] = e;
    }
    //删除某个元素
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1)
            remove(index);
    }
    //是否存在数组e
    public boolean contains(E e) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    //寻找某个元素
    public int find(E e) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    //扩容函数
    private void resizeData(int newCatacity) {
        E[] newData = (E[]) new Object[newCatacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size -1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

}
