package FindPeakElement;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        FindPeakElement2D test = new FindPeakElement2D();
        int[][] A = {{1,1,1,1}, {2,3,2,1}, {1,4,2,1}, {0,0,0,0}};
        List<Integer> res = test.findPeakII(A);
        System.out.println("row: " + res.get(0));
        System.out.println("col: " + res.get(1));
    }
}
