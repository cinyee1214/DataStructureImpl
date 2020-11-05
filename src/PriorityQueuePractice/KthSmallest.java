package PriorityQueuePractice;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallest {
    public int[] kSmallest(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < array.length; ++i) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            res[i] = maxHeap.poll();
        }

        return res;
    }
}
