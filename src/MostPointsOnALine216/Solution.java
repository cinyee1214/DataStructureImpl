package MostPointsOnALine216;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int most(Point[] points) {
        // O(n^2)
        // y = kx + c
        Map<Pair, Set<Point>> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < points.length; ++i) {
            Point a = points[i];
            for (int j = 0; j < points.length; ++j) {
                Point b = points[j];
                if (i == j || a.x == b.x && a.y == b.y) {
                    continue;
                }
                double slope = a.x == b.x ? Double.MAX_VALUE : ((a.y - b.y) + 0.0) / (a.x - b.x);
                double intercept = a.x == b.x ? a.x : a.y - slope * a.x;

                Pair cur = new Pair(slope, intercept);
                if (!map.containsKey(cur)) {
                    map.put(cur, new HashSet<Point>());
                }
                map.get(cur).add(a);
                map.get(cur).add(b);
//                int curSize = map.get(cur).size();
//                System.out.println(curSize);

            }
        }

        for (Map.Entry<Pair, Set<Point>> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue().size());
        }

        return res;
    }

    static class Pair {
        public double slope;
        public double intercept;
        public Pair(double slope, double intercept) {
            this.slope = slope;
            this.intercept = intercept;
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair) (o);
            return this.slope == p.slope && this.intercept == p.intercept;
        }

        @Override
        public int hashCode() {
            if (slope == Double.MAX_VALUE) {
                return (int) (intercept * 31);
            }

            return (int) (slope * 31 + intercept);
        }
    }

}
