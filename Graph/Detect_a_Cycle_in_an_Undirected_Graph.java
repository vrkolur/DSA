package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Detect_a_Cycle_in_an_Undirected_Graph {

    class pair {
        int first, second;

        pair(int x, int y) {
            first = x;// child
            second = y;// parent
        }
    }

    public void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public boolean isCycle_BFS(ArrayList<ArrayList<Integer>> adj, int scr, boolean vis[]) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(scr, -1));
        vis[scr] = true;
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.poll();
            for (Integer temp : adj.get(node)) {
                if (!vis[temp]) {
                    vis[temp] = true;
                    q.add(new pair(temp, node));
                } else if (temp != parent)
                    return true;
            }
        }
        return false;
    }

    public boolean isCycle_DFS(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (Integer adjNodes : adj.get(node)) {
            if (!vis[adjNodes]) {
                if (isCycle_DFS(adjNodes, node, vis, adj))
                    return true;
            } else if (adjNodes != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Detect_a_Cycle_in_an_Undirected_Graph ob = new Detect_a_Cycle_in_an_Undirected_Graph();
        int v = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        boolean vis[] = new boolean[v];
        ob.addEdge(adj, 0, 1);
        ob.addEdge(adj, 0, 2);
        ob.addEdge(adj, 2, 3);
        ob.addEdge(adj, 1, 4);
        ob.addEdge(adj, 2, 5);
        ob.addEdge(adj, 4, 6);
        // ob.addEdge(adj, 5, 6);
        // System.out.println(ob.isCycle_BFS(adj, 0, vis));
        System.out.println(ob.isCycle_DFS(0, -1, vis, adj));
    }
}
