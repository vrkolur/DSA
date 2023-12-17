package Graph;

import java.util.PriorityQueue;

public class Swim_in_Rising_Water {

    class Tuple {
        int cost, x, y;

        Tuple(int cost, int x, int y) {
            this.cost = cost;
            this.x = x;
            this.y = y;
        }
    }
    
    private int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        vis[0][0] = true;
        int[] dir = { 0, 1, 0, -1, 0 };
        pq.add(new Tuple(grid[0][0], 0, 0));
        int res=Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            Tuple it = pq.poll();
            int cost = it.cost;
            int r = it.x;
            int c = it.y;
            vis[r][c] = true;
            res = Math.max(res, cost);
            if (r == n - 1 && c == n - 1)
                return res;
            for(int k=0;k<4;k++){
                int nr = r + dir[k];
                int nc = c + dir[k + 1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]) {
                    pq.add(new Tuple(grid[nr][nc], nr, nc));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Swim_in_Rising_Water ob = new Swim_in_Rising_Water();
        int grid[][] = { { 0, 1, 3 }, { 2, 4, 1 }, { 1, 2, 1 } };
        System.out.println(ob.swimInWater(grid));
    }
}
