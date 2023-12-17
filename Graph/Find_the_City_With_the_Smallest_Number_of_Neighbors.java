package Graph;

public class Find_the_City_With_the_Smallest_Number_of_Neighbors {
    
    public int findTheCity(int n, int[][] edges, int threshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                if (i == j)
                    dist[i][j] = 0;
            }
        }
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[j][k] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int cityCount = n;
        int city = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= threshold)
                    count++;
            }
            if (count <= cityCount) {
                cityCount = count;
                city = i;
            }
        }
        return city;
    }

    public static void main(String[] args) {
        Find_the_City_With_the_Smallest_Number_of_Neighbors ob = new Find_the_City_With_the_Smallest_Number_of_Neighbors();
        // int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
        int[][] edges = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int threshold = 2;
        int n = 5;
        System.out.println(ob.findTheCity(n, edges, threshold));
    }
}
