package NQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> nqueens(int n) {
        // tc: O(n!)
        // using boolean[]
        List<List<Integer>> res = new ArrayList<>();
        traverse(n, new ArrayList<>(), res, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return res;
    }

    private void traverse(int n, List<Integer> sub, List<List<Integer>> res, boolean[] usedCol, boolean[] usedDiag, boolean[] usedRevDiag) {
        if (sub.size() == n) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!isValid(n, i, sub, usedCol, usedDiag, usedRevDiag)) {
                continue;
            }
            mark(n, i, sub, usedCol, usedDiag, usedRevDiag);
            sub.add(i);
            traverse(n, sub, res, usedCol, usedDiag, usedRevDiag);
            sub.remove(sub.size() - 1);
            unmark(n, i, sub, usedCol, usedDiag, usedRevDiag);

        }
    }

    private boolean isValid(int n, int col, List<Integer> sub, boolean[] usedCol, boolean[] usedDiag, boolean[] usedRevDiag) {
        int row = sub.size();
        return !usedCol[col] && !usedDiag[col + row] && !usedRevDiag[n - 1 + col - row];
    }

    private void mark(int n, int col, List<Integer> sub, boolean[] usedCol, boolean[] usedDiag, boolean[] usedRevDiag) {
        int row = sub.size();
        usedCol[col] = true;
        usedDiag[col + row] = true;
        usedRevDiag[n - 1 + col - row] = true;
    }

    private void unmark(int n, int col, List<Integer> sub, boolean[] usedCol, boolean[] usedDiag, boolean[] usedRevDiag) {
        int row = sub.size();
        usedCol[col] = false;
        usedDiag[col + row] = false;
        usedRevDiag[n - 1 + col - row] = false;
    }
}
