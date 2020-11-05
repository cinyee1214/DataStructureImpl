package FindPeakElement;

import java.util.Arrays;
import java.util.List;

public class FindPeakElement2D {

    public List<Integer> findPeakII(int[][] A) {
        int m = A.length, n = A[0].length;
        return findHelper(A, 1, m - 2, 1, n - 2);
    }

    private List<Integer> findHelper(int[][] A, int startRow, int endRow, int startCol, int endCol) {
        while (startRow < endRow - 1 && startCol < endCol - 1) {
            int midRow = startRow + (endRow - startRow) / 2;
            int midCol = startCol + (endCol - startCol) / 2;

            int[] max = findMax(A, startRow, endRow, startCol, endCol, midRow, midCol);
            int row = max[0], col = max[1], mx = A[row][col];
            if (row == midRow && col == midCol) return Arrays.asList(row, col);

            if (row == midRow) {
                if (mx > A[row - 1][col] && mx > A[row + 1][col]) {
                    return Arrays.asList(row, col);
                }

                if (mx < A[row - 1][col]) {
                    endRow = midRow;
                } else {
                    startRow = midRow;
                }
                if (col < midCol) {
                    endCol = midCol;
                } else {
                    startCol = midCol;
                }
            } else {
                if (mx > A[row][col - 1] && mx > A[row][col + 1]) {
                    return Arrays.asList(row, col);
                }

                if (mx < A[row][col - 1]) {
                    endCol = midCol;
                } else {
                    startCol = midCol;
                }
                if (row < midRow) {
                    endRow = midRow;
                } else {
                    startRow = midRow;
                }
            }
        }

        for (int i = startRow; i <= endRow; ++i) {
            for (int j = startCol; j <= endCol; ++j) {
                if (A[i][j] > A[i - 1][j] && A[i][j] > A[i + 1][j] && A[i][j] > A[i][j - 1] && A[i][j] > A[i][j + 1]) {
                    return Arrays.asList(i, j);
                }
            }
        }

        return Arrays.asList(-1, -1);
    }

    private int[] findMax(int[][] A, int startRow, int endRow, int startCol, int endCol, int midRow, int midCol) {
        int max = A[midRow][midCol];
        int row = midRow, col = midCol;

        for (int i = startRow; i <= endRow; ++i) {
            if (A[i][midCol] > max) {
                max = A[i][midCol];
                row = i;
                col = midCol;
            }
        }

        for (int i = startCol; i <= endCol; ++i) {
            if (A[midRow][i] > max) {
                max = A[i][midCol];
                row = midRow;
                col = i;
            }
        }

        return new int[]{row, col};
    }
}
