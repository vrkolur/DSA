package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Critical_Connections_in_a_Network {

    private int timer = 1;

    private void dfs(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj, int[] time, int[] low,List<List<Integer>> bridges) {

        vis[node] = true;
        time[node] = low[node] = timer;
        timer++;
        for (Integer it : adj.get(node)) {
            if (it == parent)
                continue;
            if (!vis[it]) {
                dfs(it, node, vis, adj, time, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                // node --- it
                if (low[it] > time[node]) {
                    bridges.add(Arrays.asList(it, node));
                }
            } else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }

    private List<List<Integer>> criticalConnections(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] it : edges) {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        boolean[] vis = new boolean[n];
        int[] time = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, adj, time, low, bridges);
        return bridges;
    }

    public static void main(String[] args) {
        Critical_Connections_in_a_Network ob = new Critical_Connections_in_a_Network();
        int connections[][] = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 },
                { 6, 9 },
                { 7, 8 }, { 8, 9 }, { 8, 10 }, { 10, 11 }, { 10, 12 }, { 12, 11 } };
        System.out.println(ob.criticalConnections(13, connections));
    }
}
