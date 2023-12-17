package Dynamic_Programming;

import java.util.Arrays;

public class Cherry_Pickup {

    private int cherryPickup(int r1, int c1, int c2, int n, int[][] grid, int[][][] t) {
        int r2 = r1 + c1 - c2;
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        if (t[r1][c1][c2] != -1)
            return t[r1][c1][c2];
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];
        int ans = grid[r1][c1];
        if (c1 != c2)
            ans += grid[r2][c2];
        int temp = Math.max(
                Math.max(cherryPickup(r1, c1 + 1, c2 + 1, n, grid, t), cherryPickup(r1, c1 + 1, c2, n, grid, t)),
                Math.max(cherryPickup(r1 + 1, c1, c2 + 1, n, grid, t), cherryPickup(r1 + 1, c1, c2, n, grid, t)));
        ans += temp;
        return t[r1][c1][c2] = ans;
    }

    public static void main(String[] args) {
        Cherry_Pickup ob = new Cherry_Pickup();
        // int grid[][] = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } };
        int[][] grid = { { 1, 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0 } };
        int[][][] t = new int[50][50][50];
        for (int[][] it : t) {
            for (int[] it1 : it) {
                Arrays.fill(it1, -1);
            }
        }
        int n = grid.length;
        System.out.println(ob.cherryPickup(0, 0, 0, n, grid, t));
        System.gc();
    }
}
