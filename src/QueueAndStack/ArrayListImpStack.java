package QueueAndStack;

//bounded Stack
public class ArrayListImpStack {
    int[] array;
    int head;
    public ArrayListImpStack(int capacity) {
        array = new int[capacity];
        head = -1;
    }

    public boolean push(int val) {
        if (head == array.length - 1) {
            return false;
        }
        array[++head] = val;
        return true;
    }

    public Integer pop() {
        return head == -1 ? null : array[head--];
    }

    public Integer top() {
        return head == -1 ? null : array[head];
    }




}
