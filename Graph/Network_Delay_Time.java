package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Network_Delay_Time {

    class Pair {
        int distance, node;

        Pair(int x, int y) {
            this.node = x;
            this.distance = y;
        }
    }

    class pqPair {
        int distance, node;

        pqPair(int x, int y) {
            this.distance = x;
            this.node = y;
        }
    }

    private int networkDelayTime(int V, int[][] times, int k) {
        int n = V + 1;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        PriorityQueue<pqPair> pq = new PriorityQueue<>((x, y) -> x.node - y.distance);
        int[] dis = new int[n];
        for (int i = 0; i < n; i++)
            dis[i] = Integer.MAX_VALUE;
        dis[k] = 0;
        pq.add(new pqPair(0, k));
        while (!pq.isEmpty()) {
            int dist = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int wt = adj.get(node).get(i).distance;
                int adjNode = adj.get(node).get(i).node;
                if (dist + wt < dis[adjNode]) {
                    dis[adjNode] = dist + wt;
                    pq.add(new pqPair(dis[adjNode], adjNode));
                }
            }
        }
        int ans = 0;
        for(int i=1;i<n;i++){
            if (dis[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dis[i]);
            // System.out.println(dis[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Network_Delay_Time ob = new Network_Delay_Time();
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4, k = 2;
        System.out.println(ob.networkDelayTime(n, times, k));
    }
}
