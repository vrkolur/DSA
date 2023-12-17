package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pacific_Atlantic_Water_Flow {

    private List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        for (int row = 0; row < n; row++) {
            dfs(row, 0, n, m, pac, heights[row][0], heights);
            dfs(row, m - 1, n, m, atl, heights[row][m - 1], heights);
        }
        for (int col = 0; col < m; col++) {
            dfs(0, col, n, m, pac, heights[0][col], heights);
            dfs(n - 1, col, n, m, atl, heights[n - 1][col], heights);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (pac[i][j] && atl[i][j])
                    result.add(Arrays.asList(i, j));
            }
        return result;
    }

    private void dfs(int i, int j, int n, int m, boolean[][] vis, int prevHeight, int[][] heights) {
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || heights[i][j] < prevHeight)
            return;
        vis[i][j] = true;
        dfs(i + 1, j, n, m, vis, heights[i][j], heights);
        dfs(i - 1, j, n, m, vis, heights[i][j], heights);
        dfs(i, j + 1, n, m, vis, heights[i][j], heights);
        dfs(i, j - 1, n, m, vis, heights[i][j], heights);
    }

    public static void main(String[] args) {
        Pacific_Atlantic_Water_Flow ob = new Pacific_Atlantic_Water_Flow();
        int heights[][] = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };
        System.out.println(ob.pacificAtlantic(heights));
    }
}
