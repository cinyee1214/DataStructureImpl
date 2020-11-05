package Practice;

import java.util.*;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        // k <<< n*m
        //minHeap  tc: O(klogk)    sc: O(k)
        int n = matrix.length, m = matrix[0].length;

        Queue<Cell> minHeap = new PriorityQueue<>();
        Set<Cell> set = new HashSet<>();
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        set.add(new Cell(0, 0, matrix[0][0]));

        while (k > 1) {
            k--;
            Cell cur = minHeap.poll();

            int row = cur.row, col = cur.col;
            if (row + 1 < n && set.add(new Cell(row + 1, col, matrix[row + 1][col]))) {
                minHeap.offer(new Cell(row + 1, col, matrix[row + 1][col]));
            }
            if (col + 1 < m && set.add(new Cell(row, col + 1, matrix[row][col + 1]))) {
                minHeap.offer(new Cell(row, col + 1, matrix[row][col + 1]));
            }

        }

        return minHeap.poll().num;
    }
}
