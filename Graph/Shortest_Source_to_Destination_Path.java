package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Source_to_Destination_Path {

    class tuple {
        int distance,row, column;

        tuple(int x, int y, int z) {
            this.distance = x;
            this.row = y;
            this.column = z;
        }
    }

    public int shortestDistance(int[][] grid, int x, int y) {
        int n = grid.length, m = grid[0].length;
        int[][] dis =new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[0][0] = 0;
        int[] dir = { 0, 1, 0, -1, 0 };
        Queue<tuple> q = new LinkedList<>();
        q.offer(new tuple(0,0, 0));
        while (!q.isEmpty()) {
            tuple it = q.poll();
            int dist = it.distance;
            int r = it.row;
            int c = it.column;
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i], nc = c + dir[i + 1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && dist + 1 < dis[nr][nc]) {
                    dis[nr][nc] = dist + 1;
                    if (nr == x && nc == y)
                        return dist + 1;
                    else
                        q.offer(new tuple(dist + 1, nr, nc));
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Shortest_Source_to_Destination_Path ob = new Shortest_Source_to_Destination_Path();
        int[][] grid = { { 1, 1, 1, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 1 } };
        System.out.println(ob.shortestDistance(grid, 2, 3));
        System.gc();
    }
}
