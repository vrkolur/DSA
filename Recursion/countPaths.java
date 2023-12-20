package Recursion;

//Backtracing

public class countPaths {
    public static int count(int i, int j, int n, int m) {

        if (i == n || j == m) {
            return 0;
        }
        if (i == n - 1 || j == m - 1) {
            return 1;
        }

        // Downward Paths
        int downPaths = count(i + 1, j, n, m);
        // Right way Paths
        int rightpaths = count(i, j + 1, n, m);

        return downPaths + rightpaths;

    }
    
    public static void main(String[] args) {
        
        int n = 4, m = 4;
        int ans = count(0, 0, n, m);
        System.out.println(ans);
    }
}
