package LongestCrossOf1s;

public class Solution {
    public int largest(int[][] matrix) {
    // Write your solution here
    if (matrix.length == 0 || matrix[0].length == 0) {
        return 0;
    }
    // DP:
    int[][] M1 = getUp(matrix);
    int[][] M2 = getDown(matrix);
    int[][] M3 = getLeft(matrix);
    int[][] M4 = getRight(matrix);

    int res = matrix[0][0];

    for (int i = 0; i < matrix.length; ++i) {
        for (int j = 0; j < matrix[0].length; ++j) {
            matrix[i][j] = Math.min(M1[i][j], M2[i][j]);
            matrix[i][j] = Math.min(matrix[i][j], M3[i][j]);
            matrix[i][j] = Math.min(matrix[i][j], M4[i][j]);
            res = Math.max(res, matrix[i][j]);
        }
    }

    return res;
}

    private int[][] getUp(int[][] matrix) {
        int[][] M1 = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; ++j) {
            M1[0][j] = matrix[0][j];
            for (int i = 1; i < matrix.length; ++i) {
                M1[i][j] = matrix[i][j] == 0 ? 0 : 1 + M1[i - 1][j];
            }
        }

        return M1;
    }

    private int[][] getDown(int[][] matrix) {
        int[][] M2 = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; ++j) {
            M2[matrix.length - 1][j] = matrix[matrix.length - 1][j];
            for (int i = matrix.length - 2; i >= 0; --i) {
                M2[i][j] = matrix[i][j] == 0 ? 0 : 1 + M2[i + 1][j];
            }
        }

        return M2;
    }
    private int[][] getLeft(int[][] matrix) {
        int[][] M3 = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            M3[i][0] = matrix[i][0];
            for (int j = 1; j < matrix[0].length; ++j) {
                M3[i][j] = matrix[i][j] == 0 ? 0 : 1 + M3[i][j - 1];
            }
        }

        return M3;
    }
    private int[][] getRight(int[][] matrix) {
        int[][] M4 = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            M4[i][matrix[0].length - 1] = matrix[i][matrix[0].length - 1];
            for (int j = matrix[0].length - 2; j >= 0; --j) {
                M4[i][j] = matrix[i][j] == 0 ? 0 : 1 + M4[i][j + 1];
            }
        }

        return M4;
    }
}
