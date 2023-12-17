package Dynamic_Programming;

import java.util.Arrays;

public class Unique_Paths {

    // First simple recursion.
    // function(i,j) means from (0,0) till (i,j) no of paths
    private int paths(int i, int j) {
        // if we reach thew position then return 1
        if (i == 0 && j == 0)
            return 1;
        // If we go out of the Matrix then we have a invalud Path so don't count
        if (i < 0 || j < 0)
            return 0;
        int up = paths(i - 1, j);
        int left = paths(i, j - 1);
        // return the sum of both
        return up + left;
    }

    // Now the Memoziation approach
    // Still uses the recursive Stack memory
    private int paths(int i, int j, int[][] t) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (t[i][j] != -1)
            return t[i][j];
        int up = paths(i - 1, j, t);
        int left = paths(i, j - 1, t);
        return t[i][j] = up + left;
    }

    // Avoid recursion stack space
    // Tabulation approach
    private int paths1(int m, int n) {
        int[][] t = new int[m][n];
        for (int i = 0; i < n; i++)
            t[0][i] = 1;
        for (int i = 1; i < m; i++)
            t[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                t[i][j] = t[i - 1][j] + t[i][j - 1];
            }
        }
        return t[m - 1][n - 1];
    }

    // Now suppose we have obstacle in the path
    // if we find a stone in the path then 0

    private int pathsObstacle(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] t = new int[m][n];
        // we we encounter a odstacle then the right side will not be reachable 
        // hence we will break from the loop before making t[i][0]=1 leave it 0 on;y.
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                t[i][0] = 1;
            else
                break;
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0)
                t[0][i] = 1;
            else
                break;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    t[i][j] = t[i - 1][j] + t[i][j - 1];
                }
            }
        }
        return t[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Unique_Paths ob = new Unique_Paths();
        int m = 4, n = 5;
        System.out.println(ob.paths(m - 1, n - 1));
        int[][] t = new int[m][n];
        for (int[] it : t)
            Arrays.fill(it, -1);
        t[0][0] = 0;
        System.out.println(ob.paths(m - 1, n - 1, t));
        System.out.println(ob.paths1(m, n));
        int[][] matrix = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 } };
        System.out.println(ob.pathsObstacle(matrix));
        System.gc();
    }
}
