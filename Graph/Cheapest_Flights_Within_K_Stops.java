package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cheapest_Flights_Within_K_Stops {

    class Pair {
        int first, second;

        Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    class Tuple {
        int first, second, third;

        Tuple(int x, int y, int z) {
            this.first = x;
            this.second = y;
            this.third = z;
        }
    }

    public int cheapestFlight(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        int m = flights.length;
        for (int i = 0; i < m; i++)
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, src, 0));
        int[] dist = new int[n];
        for (int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int stops = t.first;
            int node = t.second;
            int cost = t.third;

            if (stops > k)
                continue;
            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int wt = it.second;
                if (cost + wt < dist[adjNode]) {
                    dist[adjNode] = cost + wt;
                    q.add(new Tuple(stops + 1, adjNode, dist[adjNode]));
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE)
            return -1;
        return dist[dst];

    }

    public static void main(String[] args) {
        Cheapest_Flights_Within_K_Stops ob = new Cheapest_Flights_Within_K_Stops();
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 300 } };
        int n = 4;
        int src = 0, dst = 3, k = 1;
        System.out.println(ob.cheapestFlight(n, flights, src, dst, k));
        System.gc();
    }
}
