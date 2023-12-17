package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSF_Traversal {
    public void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public ArrayList<Integer> bfsUndirected(ArrayList<ArrayList<Integer>> adj, int v, int node) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = true;
        while (!q.isEmpty()) {
            Integer temp = q.poll();
            bfs.add(temp);
            for (Integer it : adj.get(temp)) {
                if (!vis[it]) {
                    q.offer(it);
                    vis[it] = true;
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        BSF_Traversal ob = new BSF_Traversal();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int v = 5;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        ob.addEdge(adj, 0, 1);
        ob.addEdge(adj, 0, 4);
        ob.addEdge(adj, 1, 4);
        ob.addEdge(adj, 3, 4);
        ob.addEdge(adj, 1, 3);
        ob.addEdge(adj, 1, 2);
        ob.addEdge(adj, 3, 2);
        System.out.println(ob.bfsUndirected(adj, v, 1));
    }

}
