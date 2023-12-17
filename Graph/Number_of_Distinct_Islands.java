package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Number_of_Distinct_Islands {

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int vis[][] = new int[n][m];

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<int[]> list = new ArrayList<>();
                    dfs(grid, vis, i, j, list, i, j);
                    set.add(toString(list));
                }
            }
        }
        return set.size();
    }

    public String toString(ArrayList<int[]> list) {
        String ans = "";
        for (int[] val : list) {
            for (int num : val) {
                ans += num;
            }
        }
        return ans;
    }

    int dir[] = { 0, 1, 0, -1, 0 };

    void dfs(int[][] grid, int[][] vis, int i, int j, ArrayList<int[]> island, int br, int bc) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
                || vis[i][j] == 1 || grid[i][j] == 0)
            return;

        vis[i][j] = 1;
        island.add(new int[] { i - br, j - bc });

        for (int k = 0; k < 4; k++) {
            dfs(grid, vis, i + dir[k], j + dir[k + 1], island, br, bc);
        }
    }

    public static void main(String[] args) {
        Number_of_Distinct_Islands ob = new Number_of_Distinct_Islands();
        int[][] grid = { { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 1, 1, 0, 1, 1 } };
        System.out.println(ob.countDistinctIslands(grid));
    }
}
