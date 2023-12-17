package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Strongly_Connected_Components_Kosarajus_Algo {

    private void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
    
    private void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> s) {
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, s);
            }
        }
        s.push(node);
    }

    private void dfs2(int node, boolean vis[], ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = true;
        for (Integer it : adjT.get(node)) {
            if (!vis[it]) {
                dfs2(it, vis, adjT);
            }
        }
    }

    private int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, s);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjT.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            vis[i] = false;
            for (Integer it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }
        int scc = 0;
        while (!s.isEmpty()) {
            int node = s.pop();
            if (!vis[node]) {
                scc++;
                dfs2(node, vis, adjT);
            }
        }
        return scc;
    }

    public static void main(String[] args) {
        Strongly_Connected_Components_Kosarajus_Algo ob = new Strongly_Connected_Components_Kosarajus_Algo();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int v = 8;
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        ob.addEdge(adj, 0,1);
        ob.addEdge(adj, 1,2);
        ob.addEdge(adj, 2,0);
        ob.addEdge(adj, 2,3);
        ob.addEdge(adj, 3,4);
        ob.addEdge(adj, 4,5);
        ob.addEdge(adj, 4,7);
        ob.addEdge(adj, 5,6);
        ob.addEdge(adj, 6,7);
        ob.addEdge(adj, 6, 4);
        System.out.println(ob.kosaraju(v, adj));
    }
}
