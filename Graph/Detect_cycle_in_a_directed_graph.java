package Graph;

import java.util.ArrayList;

public class Detect_cycle_in_a_directed_graph {

    public void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean path[]) {
        vis[node] = true;
        path[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (dfs(it, adj, vis, path))
                    return true;
            } else if (path[it])
                return true;
        }
        path[node] = false;
        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v];
        boolean path[] = new boolean[v];
        for (int i = 1; i < v; i++) {
            if (!vis[i])
                if (dfs(i, adj, vis, path))
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Detect_cycle_in_a_directed_graph ob = new Detect_cycle_in_a_directed_graph();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 11;
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());
        ob.addEdge(adj, 1, 2);
        ob.addEdge(adj, 2, 3);
        ob.addEdge(adj, 3, 4);
        ob.addEdge(adj, 4, 5);
        ob.addEdge(adj, 5, 6);
        ob.addEdge(adj, 3, 7);
        ob.addEdge(adj, 7, 5);
        ob.addEdge(adj, 8, 2);
        ob.addEdge(adj, 8, 9);
        ob.addEdge(adj, 9, 10);
        ob.addEdge(adj, 10, 8);
        System.out.println(ob.isCycle(adj, v));
    }
}
