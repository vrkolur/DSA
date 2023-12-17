package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Shortest_path_in_Directed_Acyclic_Graph {

    class Pair {
        int first, cost;

        Pair(int x, int y) {
            first = x;
            cost = y;
        }
    }

    public void dfs(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> s) {
        vis[node] = true;
        for (int it = 0; it < adj.get(node).size(); it++) {
            int v = adj.get(node).get(it).first;
            if (!vis[v])
                dfs(v, adj, vis, s);
        }
        s.push(node);
    }

    public int[] shortestPath(int n, int m, int[][] graph) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Pair>());

        for (int i = 0; i < m; i++) {
            int u = graph[i][0], v = graph[i][1], wt = graph[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        boolean vis[] = new boolean[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i])
                dfs(i, adj, vis, s);
        }
        int dis[] = new int[n];
        for (int i = 0; i < n; i++)
            dis[i] = 9999;

        dis[6] = 0;
        // for (int i = 0; i < n; i++)
        //     System.out.print(s.pop() + " ");
        while (!s.isEmpty()) {
            int node = s.pop();
            for (Pair it : adj.get(node)) {
                int v = it.first, wt = it.cost;
                if (dis[node] + wt < dis[v]) {
                    dis[v] = dis[node] + wt;
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        Shortest_path_in_Directed_Acyclic_Graph ob = new Shortest_path_in_Directed_Acyclic_Graph();
        int[][] graph = { { 6, 4, 2 }, { 6, 5, 3 }, { 5, 4, 1 }, { 4, 0, 3 }, { 4, 2, 1 }, { 0, 1, 2 }, { 1, 3, 1 },
                { 2, 3, 3 } };
        int n = 7, m = graph.length;
        int res[] = ob.shortestPath(n, m, graph);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
