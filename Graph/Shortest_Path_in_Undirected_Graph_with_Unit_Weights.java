package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_in_Undirected_Graph_with_Unit_Weights {

    public int[] findShortest(int[][] graph, int n, int m,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        for (int i = 0; i < m; i++) {
            adj.get(graph[i][0]).add(graph[i][1]);
            adj.get(graph[i][1]).add(graph[i][0]);
        }
        int dis[] = new int[n];
        for (int i = 0; i < n; i++)
            dis[i] = Integer.MAX_VALUE;
        dis[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int it : adj.get(node)) {
                if (dis[node] + 1 < dis[it]) {
                    dis[it] = dis[node] + 1;
                    q.offer(it);
                }
            }
        }

        return dis;
    }

    public static void main(String[] args) {
        Shortest_Path_in_Undirected_Graph_with_Unit_Weights ob = new Shortest_Path_in_Undirected_Graph_with_Unit_Weights();
        int[][] graph = { { 0, 1 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 2, 6 }, { 6, 7 },
                { 6, 8 }, { 7, 8 } };
        int res[] = ob.findShortest(graph, 9, 11, 0);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.gc();
    }
}
