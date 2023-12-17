// package Dynamic_Programming;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum {

    // This is the recursive approach
    private int findmin(int[][] matrix, int i, int j) {
        if (j < 0 || j >= matrix[0].length)
            return Integer.MAX_VALUE - 987;
        if (i == 0)
            return matrix[0][j];
        int up = matrix[i][j] + findmin(matrix, i - 1, j);
        int ld = matrix[i][j] + findmin(matrix, i - 1, j - 1);
        int rd = matrix[i][j] + findmin(matrix, i - 1, j + 1);
        return Math.min(up, Math.min(ld, rd));
    }

    // This is a memoziation
    // Very few overlapping are present hence not huge improvenemt in time
    private int findmin(int[][] matrix, int i, int j, int[][] t) {
        if (j < 0 || j >= matrix[0].length)
            return Integer.MAX_VALUE - 987;
        if (i == 0)
            return matrix[0][j];
        if (t[i][j] != -1)
            return t[i][j];
        int up = matrix[i][j] + findmin(matrix, i - 1, j);
        int ld = matrix[i][j] + findmin(matrix, i - 1, j - 1);
        int rd = matrix[i][j] + findmin(matrix, i - 1, j + 1);
        return t[i][j] = Math.min(up, Math.min(ld, rd));
    }
    
    // This is the tabulation best in time complexity
    private int findmin(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] t = new int[n][m];
        for(int j=0;j<m;j++)
            t[0][j] = matrix[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + t[i - 1][j];
                int ld = Integer.MAX_VALUE-9876;
                if (j - 1 >= 0)
                    ld = matrix[i][j] + t[i - 1][j - 1];
                int rd = Integer.MAX_VALUE-9876;
                if (j + 1 < m)
                    rd = matrix[i][j] + t[i - 1][j + 1];
                t[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }
        int res = t[n - 1][0];
        for (int j = 0; j < m; j++) {
            res = Math.min(res, t[n - 1][j]);
        }
        return res;
    }

    public static void main(String[] args) {
        Minimum_Falling_Path_Sum ob = new Minimum_Falling_Path_Sum();
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        // System.out.println(ob.findmin(matrix,0,0));
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] t = new int[n][m];
        for (int it[] : t)
            Arrays.fill(it, -1);
        for (int j = 0; j < m; j++) {
            int maxi = ob.findmin(matrix, n - 1, j);
            res = Math.min(res, maxi);
        }
        System.out.println(res);
        System.out.println(ob.findmin(matrix));
    }
}
