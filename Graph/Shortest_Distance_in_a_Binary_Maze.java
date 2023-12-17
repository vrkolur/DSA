package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Distance_in_a_Binary_Maze {

    class tuple {
        int first, row, column;

        tuple(int x, int y, int z) {
            this.first = x;
            this.row = y;
            this.column = z;
        }
    }

    public int shortestPath(int[][] grid, int[] src, int[] dest) {

        if (src[0] == dest[0] && src[1] == dest[1])
            return 0;
        Queue<tuple> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        // dis-> is the distance grid
        int dis[][] = new int[n][m];
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis[0].length; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[src[0]][src[1]] = 0;
        q.offer(new tuple(0, src[0], src[1]));
        int[] dir = { 0, 1, 0, -1, 0 };
        while (!q.isEmpty()) {
            tuple it = q.poll();
            // dist-> is the current distace.
            int dist = it.first;
            int r = it.row;
            int c = it.column;
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i], nc = c + dir[i + 1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && dist + 1 < dis[nr][nc]) {
                    dis[nr][nc] = dist + 1;
                    if (nr == dest[0] && nc == dest[1])
                        return dist + 1;
                    else
                        q.offer(new tuple(dist + 1, nr, nc));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Shortest_Distance_in_a_Binary_Maze ob = new Shortest_Distance_in_a_Binary_Maze();
        int[][] grid = { { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 } };
        int src[] = { 0, 1 };
        int dest[] = { 4,0 };
        System.out.println(ob.shortestPath(grid, src, dest));
        System.gc();
    }
}
