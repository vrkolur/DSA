package Graph;

public class Distance_from_the_Source_Bellman_Ford_Algorithm {

    public int[] bellmanFord(int[][] edges, int n, int src) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++)
            dist[i] = (int) 1e8;
        dist[src] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int[] it : edges) {
                int u = it[0];
                int v = it[1];
                int wt = it[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }

        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Distance_from_the_Source_Bellman_Ford_Algorithm ob = new Distance_from_the_Source_Bellman_Ford_Algorithm();
        // int[][] edges = { { 0, 1, 5 }, { 1, 2, -2 }, { 3, 2, 6 }, { 5, 3, 1 }, { 1, 5, -3 }, { 2, 4, 3 },
        //         { 3, 4, -2 } };
        int[][] edges = { {1,2,-2},{2,3,-1},{3,1,2} };
        int n = 6;
        int[] res = ob.bellmanFord(edges, n, 1);
        for (int i : res) {
            System.out.print(i+" ");
        }
        System.gc();
    }
}
