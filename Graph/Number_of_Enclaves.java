package Graph;

public class Number_of_Enclaves {

    int[] dir = { 0, 1, 0, -1, 0 };

    //This problem is the same as of Surrounded Regions, See that comrade.
    private void dfs(int i, int j, int[][] grid, boolean[][] vis) {
        // if (grid[i][j] == 1)
            vis[i][j] = true;
        int n = grid.length, m = grid[0].length;
        for (int k = 0; k < 4; k++) {
            int r = i + dir[k], c = j + dir[k + 1];
            if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1 && !vis[r][c])
                dfs(r, c, grid, vis);
        }
    }

    private int numEnclaves(int[][] grid, boolean[][] vis) {
        int count=0;
        int m = grid.length, n = grid[0].length;
        // Traverse both border rows
        for (int i = 0; i < n; i++) {
            if (!vis[0][i] && grid[0][i] == 1)
                dfs(0, i, grid, vis);
            if (!vis[m - 1][i] && grid[m - 1][i] == 1)
                dfs(m - 1, i, grid, vis);
        }
        // dfs(3, 0, grid, vis);
        // Traverse both the end columns
        for (int j = 0; j < m; j++) {
            if (!vis[j][0] && grid[j][0] == 1)
                dfs(j, 0, grid, vis);
            if (!vis[j][n - 1] && grid[j][n - 1] == 1)
                dfs(j, n - 1, grid, vis);
        }
        // after doing change the 0->x
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Number_of_Enclaves ob = new Number_of_Enclaves();
        int[][] grid = { { 0, 0, 0, 0 }, { 0, 1, 1, 0, }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        System.out.println(ob.numEnclaves(grid, vis));
    }
}
