package Graph;

import java.util.ArrayList;
import java.util.List;

// This problem is Number of Islands in GFG
public class Number_Of_Islands_II {

    private boolean isValid(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public List<Integer> numOfIslands(int n, int m, int[][] operations) {
        DisjointSets ds = new DisjointSets(n * m);
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        List<Integer> res = new ArrayList<>();
        int dir[] = { 0, 1, 0, -1, 0 };
        for (int i = 0; i < operations.length; i++) {
            int r = operations[i][0];
            int c = operations[i][1];

            if (vis[r][c]) {
                res.add(count);
                continue;
            }
            vis[r][c] = true;
            count++;
            for (int k = 0; k < 4; k++) {
                int nr = r + dir[k];
                int nc = c + dir[k + 1];
                if (isValid(nr, nc, n, m)) {
                    if (vis[nr][nc]) {
                        int node = r * m + c;
                        int adjNode = nr * m + nc;

                        if (ds.findUltiParent(node) != ds.findUltiParent(adjNode)) {
                            count--;
                            ds.unionbyRank(node, adjNode);
                        }
                    }

                }
            }
            res.add(count);
        }
        return res;
    }

    public static void main(String[] args) {
        Number_Of_Islands_II ob = new Number_Of_Islands_II();
        int[][] operations = { { 0, 0 }, { 0, 0 }, { 1, 1 }, { 1, 0 }, { 0, 1 }, { 0, 3 }, { 1, 3 }, { 0, 4 }, { 3, 2 },
                { 2, 2 }, { 1, 2 }, { 0, 2 } };
        int n = 4;
        int m = 5;
        System.out.println(ob.numOfIslands(n, m, operations));
    }
}
