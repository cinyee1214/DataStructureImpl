package KthClosestPoint194;

import java.util.*;

public class Solution {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                int d1 = a[l1.get(0)] * a[l1.get(0)] + b[l1.get(1)] * b[l1.get(1)] + c[l1.get(2)] * c[l1.get(2)];
                int d2 = a[l2.get(0)] * a[l2.get(0)] + b[l2.get(1)] * b[l2.get(1)] + c[l2.get(2)] * c[l2.get(2)];

                return d1 < d2 ? -1 : 1;
            }
        });

        Set<List<Integer>> visited = new HashSet<>();

        List<Integer> cur = Arrays.asList(0, 0, 0);
        visited.add(cur);
        pq.offer(cur);

        while (k > 1) {
            k--;
            cur = pq.poll();

            List<Integer> nxt = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
            if (nxt.get(0) < a.length && visited.add(nxt)) {
                pq.offer(nxt);
            }

            nxt = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
            if (nxt.get(1) < b.length && visited.add(nxt)) {
                pq.offer(nxt);
            }

            nxt = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
            if (nxt.get(2) < c.length && visited.add(nxt)) {
                pq.offer(nxt);
            }
        }

        cur = pq.poll();
        return Arrays.asList(a[cur.get(0)], b[cur.get(1)], c[cur.get(2)]);
    }
}

