package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {

    class Pair {
        int first, second;

        // first-> node.
        // second-> if 0 then no path if 1 then there is a directed path
        Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    private int minReorder(int n, int connection[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] it : connection) {
            adj.get(it[0]).add(new Pair(it[1], 1));
            adj.get(it[1]).add(new Pair(it[0], 0));
        }
        boolean[] vis = new boolean[n];
        int res = 0;
        Queue<Integer> q = new LinkedList<>(); 
        q.offer(0);
        while (!q.isEmpty()) {
            int city = q.poll();
            if (vis[city])
                continue;
            vis[city] = true;
            for (Pair it : adj.get(city)) {
                if (!vis[it.first]) {
                    q.offer(it.first);

                    if (it.second == 1)
                        res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero ob = new Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero();
        int connection[][] = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
        int n = 6;
        System.out.println(ob.minReorder(n, connection));
    }
}
