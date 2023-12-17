package Dynamic_Programming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Cherry_Pickup_II {

    // This is the recursive approach
    int[] dir = { -1, 0, 1 };

    private int cherryPickup(int i, int j1, int j2, int n, int m, int[][] grid) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return (int) (Math.pow(-10, 9));

        // If we are at the last row, return the sum of chocolates in the selected
        // columns
        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        int maxi = Integer.MIN_VALUE;
        // Iterate through possible moves in the next row
        for (int d1 : dir) {
            for (int d2 : dir) {
                int ans;
                // If j1 and j2 are the same, add chocolates from grid[i][j1] only
                if (j1 == j2)
                    ans = grid[i][j1] + cherryPickup(i + 1, j1 + d1, j2 + d2, n, m, grid);
                else
                    // Add chocolates from both j1 and j2
                    ans = grid[i][j1] + grid[i][j2] + cherryPickup(i + 1, j1 + d1, j2 + d2, n, m, grid);
                // Update maxi with the maximum result
                maxi = Math.max(maxi, ans);
            }
        }
        return maxi;
    }

    // This is the space optimised Approach
    private int cherryPickup(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] t) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return (int) (Math.pow(-10, 9));
        // If already calculated
        if (t[i][j1][j2] != -1)
            return t[i][j1][j2];
        // Suppose we are int the last row
        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        int maxi = Integer.MIN_VALUE;
        for (int d1 : dir) {
            for (int d2 : dir) {
                int ans;
                if (j1 == j2)
                    ans = grid[i][j1] + cherryPickup(i + 1, j1 + d1, j2 + d2, n, m, grid, t);
                else
                    ans = grid[i][j1] + grid[i][j2] + cherryPickup(i + 1, j1 + d1, j2 + d2, n, m, grid, t);
                maxi = Math.max(maxi, ans);
            }
        }
        return t[i][j1][j2] = maxi;
    }

    // Now tobulation
    private int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] t = new int[n][m][m];
        // First the base case if they are at the bottom most postion;
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    t[n - 1][j1][j2] = grid[n - 1][j2];
                else
                    t[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }
        //Now for the remaning three for loops we have to do shit
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;
                    //the below two for loops will only take O(9) of time so basically constant  time only.
                    for (int d1 : dir) {
                        for (int d2 : dir) {
                            int ans = 0;
                            //Only if inside the grid
                            if (j1 + d1 >= 0 && j1 + d1 <m && j2 + d2 >= 0 && j2 + d2 < m) {
                                if (j1 == j2)
                                    ans = grid[i][j1] + t[i + 1][j1 + d1][j2 + d2];
                                else
                                    ans = grid[i][j1] + grid[i][j2] + t[i + 1][j1 + d1][j2 + d2];
                            }
                            maxi = Math.max(maxi, ans);
                        }
                    }
                    t[i][j1][j2] = maxi;
                }
            }
        }
        return t[0][0][m - 1];
    }

    public static void main(String[] args) {
        Cherry_Pickup_II ob = new Cherry_Pickup_II();
        int[][] grid = { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };
        int n = grid.length;
        int m = grid[0].length;
        System.out.println(ob.cherryPickup(0, 0, m - 1, n, m, grid));
        int[][][] t = new int[n][m][m];
        for (int[][] it : t) {
            for (int[] it1 : it) {
                Arrays.fill(it1, -1);
            }
        }
        System.out.println(ob.cherryPickup(0, 0, m - 1, n, m, grid, t));
        System.out.println(ob.cherryPickup(grid));
        System.gc();
    }
}
