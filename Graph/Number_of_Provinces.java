package Graph;

import java.util.ArrayList;

public class Number_of_Provinces {

    public void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it])
                dfs(it, vis, adj);
        }
    }

    public int countProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v + 1];
        int count = 0;
        for (int i = 1; i <= v; i++) {
            if (!vis[i]) {
                vis[i] = true;
                dfs(i, vis, adj);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Number_of_Provinces ob = new Number_of_Provinces();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int v = 8;
        for (int i = 0; i <= 8; i++)
            adj.add(new ArrayList<>());
        ob.addEdge(adj, 1, 2);
        ob.addEdge(adj, 2, 3);
        ob.addEdge(adj, 4, 5);
        ob.addEdge(adj, 4, 6);
        ob.addEdge(adj, 7, 8);
        System.out.println(ob.countProvinces(adj, v));
        System.gc();
    }
}
