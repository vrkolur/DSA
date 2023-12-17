package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Number_of_Ways_to_Arrive_at_Destination {

    class Pair {
        int first, second;

        Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        int m = roads.length;
        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
         int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int)1e9;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));
        int mod = (int) 1e9;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int dis = cur.first;
            int node = cur.second;

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int wt = it.second;
                if (dis + wt < dist[adjNode]) {
                    dist[adjNode] = dis + wt;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair((int)dist[adjNode], adjNode));
                }
                else if (dis + wt == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return (int)ways[n-1] %mod;
    }
    
    public static void main(String[] args) {
        Number_of_Ways_to_Arrive_at_Destination ob = new Number_of_Ways_to_Arrive_at_Destination();
        int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
                { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
        int n = 7;
        System.out.println(ob.countPaths(n, roads));
        System.out.println(Integer.MAX_VALUE);
    }
}
