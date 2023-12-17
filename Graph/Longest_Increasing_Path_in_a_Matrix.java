package Graph;

public class Longest_Increasing_Path_in_a_Matrix {

    private int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (memo[i][j] == 0) {
                    res = Math.max(res, dfs(i, j, n, m, matrix, memo));
                }
            }
        }
        return res;
    }

    int dir[] = { 0, 1, 0, -1, 0 };

    private int dfs(int i, int j, int n, int m, int[][] matrix, int[][] memo) {
        if (memo[i][j] > 0)
            return memo[i][j];
        int ans = 1;
        for (int k = 0; k < 4; k++) {
            int nr = i + dir[k];
            int nc = j + dir[k + 1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] > matrix[i][j]) {
                ans = Math.max(ans, dfs(nr, nc, n, m, matrix, memo) + 1);
            }
        }
        memo[i][j] = ans;
        return ans;

    }

    public static void main(String[] args) {
        Longest_Increasing_Path_in_a_Matrix ob = new Longest_Increasing_Path_in_a_Matrix();
        int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        System.out.println(ob.longestIncreasingPath(matrix));
    }
}
