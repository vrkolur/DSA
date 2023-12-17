package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Topological_sort {

    public void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    // Using normal DFS algorithm.
    public List<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] vis = new boolean[v];
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i])
                dfs(i, adj, vis, s);
        }
        while (!s.isEmpty()) {
            res.add(s.peek());
            s.pop();
        }
        return res;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> s) {
        vis[node] = true;
        for (int temp : adj.get(node)) {
            if (!vis[temp])
                dfs(temp, adj, vis, s);
        }
        s.push(node);
    }

    // Using BFS Khan's Algoithm
    public List<Integer> kahnAlgorithm(ArrayList<ArrayList<Integer>> adj, int v) {
        List<Integer> res = new ArrayList<>();

        int indegree[] = new int[v];
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i))
                indegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.offer(it);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Topological_sort ob = new Topological_sort();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 6;
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());
        ob.addEdge(adj, 4, 0);
        ob.addEdge(adj, 4, 1);
        ob.addEdge(adj, 5, 0);
        ob.addEdge(adj, 5, 2);
        ob.addEdge(adj, 2, 3);
        ob.addEdge(adj, 3, 1);
        // System.out.println(ob.topoSort(adj, v));
        System.out.println(ob.kahnAlgorithm(adj, v));
    }
}
