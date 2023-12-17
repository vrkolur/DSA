package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskals_Algorithm {

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int x, int y, int z) {
            this.src = x;
            this.dest = y;
            this.weight = z;
        }

        public int compareTo(Edge that) {
            return this.weight - that.weight;
        }
    }

    public int spanningTree(int graph[][]) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            Edge temp = new Edge(graph[i][0], graph[i][1], graph[i][2]);
            edges.add(temp);
        }
        DisjointSets ds = new DisjointSets(7);
        Collections.sort(edges);
        int sum = 0;
        for (int i = 0; i < graph.length; i++) {
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            int wt = edges.get(i).weight;

            if (ds.findUltiParent(u) != ds.findUltiParent(v)) {
                sum += wt;
                ds.unionbyRank(u, v);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Kruskals_Algorithm ob = new Kruskals_Algorithm();
        int[][] edges = { { 5, 4, 9 }, { 5, 4, 1 }, { 4, 3, 5 }, { 1, 2, 2 }, { 4, 1, 1 }, { 4, 2, 3 }, { 3, 2, 3 },
                { 3, 6, 8 }, { 2, 7, 6 } };
        System.out.println(ob.spanningTree(edges));
    }
}
