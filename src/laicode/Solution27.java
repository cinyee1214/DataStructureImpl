package laicode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution27 {
    public int kthSum(int[] A, int[] B, int k) {
        // data structure: minHeap, HashSet
        // algorithm: BFS-2
        // tc: O(klogk), sc:O(k)
        int m = A.length, n = B.length;
        Queue<Cell> queue = new PriorityQueue<>(k);
        Set<Cell> set = new HashSet<>();
        queue.offer(new Cell(0, 0, A[0] + B[0]));
        set.add(new Cell(0, 0, A[0] + B[0]));

        while (k > 1) {
            k--;
            Cell cur = queue.poll();
            int i = cur.a, j = cur.b;
            if (i + 1 < m && set.add(new Cell(i + 1, j, A[i + 1] + B[j]))) {
                queue.offer(new Cell(i + 1, j, A[i + 1] + B[j]));
            }

            if (j + 1 < n && set.add(new Cell(i, j + 1, A[i] + B[j + 1]))) {
                queue.offer(new Cell(i, j + 1, A[i] + B[j + 1]));
            }
        }

        return queue.poll().sum;
    }

    static class Cell implements Comparable<Cell> {
        int a, b, sum;
        public Cell(int a, int b, int sum) {
            this.a = a;
            this.b = b;
            this.sum = sum;
        }

        @Override
        public int compareTo(Cell c) {
            if (this.sum == c.sum) {
                return 0;
            }
            return this.sum < c.sum ? -1: 1;
        }

        @Override
        public boolean equals(Object o) {
            Cell c = (Cell) (o);
            return this.a == c.a && this.b == c.b;
        }

        @Override
        public int hashCode() {
            return a * 31 * 31 + b * 31 + sum;
        }
    }
}
