package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Update_01_Matrix {
    int dir[] = { 0, 1, 0, -1, 0 };

    public void updateMetrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    q.offer(new int[] { i, j });
                else
                    grid[i][j] = -1;
            }
        }
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i], nc = c + dir[i + 1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != -1)
                    continue;
                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[] { nr, nc });
            }
        }
    }

    public static void main(String[] args) {
        Update_01_Matrix ob = new Update_01_Matrix();
        int grid[][] = { { 0, 0, 0, }, { 0, 1, 0 }, { 1, 1, 1 } };
        ob.updateMetrix(grid);
        System.out.println(grid[2][1]);
    }
}
