package QueueAndStack;

//circular array
public class ArrayImpQueue {
    int head, tail, size;
    int[] array;

    public ArrayImpQueue(int capacity) {
        array = new int[capacity];
        head = tail = 0;
        size = 0;
    }

    public boolean offer(int val) {
        if (size == array.length) {
            return false;
        }

        array[tail++] = val;
        tail = tail % array.length;

        size++;
        return true;
    }

    public Integer peek() {
        return size == 0 ? null : array[head];

    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int num = array[head++];
        head = head % array.length;
        size--;
        return num;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

}
