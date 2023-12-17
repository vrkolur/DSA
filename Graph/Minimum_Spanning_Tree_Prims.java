package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Minimum_Spanning_Tree_Prims {

    // class Pair {
    // int node;
    // int distance;

    // Pair(int x, int y) {
    // this.node = x;
    // this.distance = y;
    // }

    // }
    class Pair implements Comparable<Pair> {
        int node;
        int distance;

        Pair(int v, int wt) {
            this.node = v;
            this.distance = wt;
        }

        public int compareTo(Pair that) {
            return this.distance - that.distance;
        }

    }

    public int spanningTree(int V, int e, int edges[][]) {
        boolean vis[] = new boolean[V];
        int ans = 0;
        // PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance -
        // y.distance);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] i : edges) {
            adj.get(i[0]).add(new Pair(i[1], i[2]));
            adj.get(i[1]).add(new Pair(i[0], i[2]));

        }
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            if (vis[node]) {
                continue;
            }
            vis[node] = true;
            ans += curr.distance;
            for (Pair it : adj.get(node)) {
                if (!vis[it.node])
                    pq.add(new Pair(it.node, it.distance));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Minimum_Spanning_Tree_Prims ob = new Minimum_Spanning_Tree_Prims();
        int edges[][] = { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 4, 7 }, { 1, 4, 5 }, { 1, 3, 8 }, { 0, 3, 6 } };
        // int edges[][] = { {0,1,5},{1,2,3},{0,2,1} };
        int v = 5;
        System.out.println(ob.spanningTree(v, 6, edges));
    }
}
