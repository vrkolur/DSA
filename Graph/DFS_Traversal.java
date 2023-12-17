package Graph;

import java.util.ArrayList;

public class DFS_Traversal {
    public void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
        vis[node] = true;
        res.add(node);
        for (Integer it : adj.get(node)) {
            if (!vis[it])
                dfs(it, vis, adj, res);
        }
    }

    public static void main(String[] args) {
        DFS_Traversal ob = new DFS_Traversal();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int v = 8;
        for (int i = 0; i <=v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        ob.addEdge(adj, 1, 2);
        ob.addEdge(adj, 2, 5);
        ob.addEdge(adj, 2, 6);
        ob.addEdge(adj, 1, 3);
        ob.addEdge(adj, 3, 7);
        ob.addEdge(adj, 7, 8);
        ob.addEdge(adj, 8, 4);
        ob.addEdge(adj, 4, 3);
        ArrayList<Integer> res = new ArrayList<>();
        boolean vis[] = new boolean[v+1];
        ob.dfs(3, vis, adj, res);
        System.out.println(res);
        System.gc();
    }
}
