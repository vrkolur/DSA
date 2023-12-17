package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Bridge {

    int dir[] = { 0, 1, 0, -1, 0 };

    private int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int x = -1, y = -1;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (flag)
                break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    flag = true;
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        dfs(x, y, n, grid, vis, q);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] it = q.poll();
                for (int k = 0; k < 4; k++) {
                    int r = it[0] + dir[k];
                    int c = it[1] + dir[k + 1];
                    if (r >= 0 && r < n && c >= 0 && c < n && !vis[r][c]) {
                        if (grid[r][c] == 1)
                            return steps;
                        q.add(new int[] { r, c });
                        vis[r][c] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int i, int j, int n, int[][] grid, boolean[][] vis, Queue<int[]> q) {
        if (vis[i][j])
            return;
        vis[i][j] = true;
        q.add(new int[] { i, j });
        for (int k = 0; k < 4; k++) {
            int nr = i + dir[k];
            int nc = j + dir[k + 1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1 && !vis[nr][nc]) {
                dfs(nr, nc, n, grid, vis, q);
            }
        }
    }

    public static void main(String[] args) {
        Shortest_Bridge ob = new Shortest_Bridge();
        int[][] grid = { { 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1 } };
        System.out.println(ob.shortestBridge(grid));
    }
}
