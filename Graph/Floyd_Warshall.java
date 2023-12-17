package Graph;

public class Floyd_Warshall {

    public void floydWarshall(int[][] graph) {
        int n = graph.length;
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], (graph[i][via] + graph[via][j]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Floyd_Warshall ob = new Floyd_Warshall();
        int[][] graph = { { 0, 2, 999, 999 }, { 1, 0, 3, 999 }, { 999, 999, 0, 999 }, { 3, 5, 4, 0 } };
        ob.floydWarshall(graph);
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
