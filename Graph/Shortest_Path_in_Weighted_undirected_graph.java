package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Shortest_Path_in_Weighted_undirected_graph {

    static class Pair {
        int first, second;

        Pair(int x, int y) {
            first = x;
            second = y;
        }
    }

    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        int[] dis = new int[n + 1];
        int parent[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        dis[1] = 0;
        pq.add(new Pair(0, 1));
        while (!pq.isEmpty()) {
            int node = pq.peek().second;
            int dist = pq.peek().first;
            pq.remove();
            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int wt = it.second;
                if (dist + wt < dis[adjNode]) {
                    dis[adjNode] = dist + wt;
                    pq.add(new Pair(dis[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (dis[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Shortest_Path_in_Weighted_undirected_graph ob = new Shortest_Path_in_Weighted_undirected_graph();
        int[][] edges = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
        int n = 5;
        int e = 6;
        System.out.println(ob.shortestPath(n, e, edges));
    }
}
