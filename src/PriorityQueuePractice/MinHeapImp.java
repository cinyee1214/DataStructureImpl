package PriorityQueuePractice;

import java.util.NoSuchElementException;

public class MinHeapImp {
    private int[] array;
    private int size;

    public MinHeapImp(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("Capacity cannot be <= 0.");
        }
        array = new int[cap];
        size = 0;
    }

    public MinHeapImp(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }
        this.array = array;
        size = array.length;
        heapify();
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

    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; --i) {
            percolateDown(i);
        }
    }

    private void percolateDown(int index) {
        //check left child
        while (index * 2 + 1 < size) {
            int left = 2 * index + 1, right = 2 * index + 2;
            int candidate = left;
            if (right < size && array[right] < array[left]) {
                candidate = right;
            }
            if (array[index] < array[candidate]) {
                return;
            }
            swap(index, candidate);
            index = candidate;
        }
    }

    private void percolateUp(int index) {
        //check parent
        int parentIndex;
        while ((parentIndex = (index - 1) / 2) >= 0 && array[index] < array[(index - 1) / 2]) {
            // int parentIndex = (index - 1) / 2;
            swap(index, parentIndex);
            index = parentIndex;
        }

    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty.");
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty.");
        }
        int result = array[0];
        array[0] = array[--size];
        percolateDown(0);
        return result;
    }

    public void offer(int ele) {
        if (isFull()) {
            int[] newArray = new int[(int) (size * 1.5)];
            for (int i = 0; i < size; ++i) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

        array[size++] = ele;
        percolateUp(size - 1);
    }

    //return the original value
    public int update(int index, int ele) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Invalid index range.");
        }
        int result = array[index];
        array[index] = ele;
        if (ele < result) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        return result;
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
