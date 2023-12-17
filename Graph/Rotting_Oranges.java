package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {

       // a simple bfs should do the work.
    public int orangeRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[] { i, j });
                if (grid[i][j] == 1)
                    countFresh++;
            }
        }
        if (countFresh == 0)
            return 0;
        if (q.isEmpty())
            return -1;
        int min = -1;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cell = q.remove();
                int r = cell[0];
                int c = cell[1];

                for (int[] dir : dirs) {
                    int i = r + dir[0];
                    int j = c + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        countFresh--;
                        q.offer(new int[] { i, j });
                    }
                }
            }
            min++;
        }

        if (countFresh == 0)
            return min;
        return -1;
    }

    public static void main(String[] args) {
        Rotting_Oranges ob = new Rotting_Oranges();
        int grid[][] = { { 2, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(ob.orangeRotting(grid));
    }
}
