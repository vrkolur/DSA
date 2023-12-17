package Dynamic_Programming;

import java.util.Arrays;

public class Knapsack01 {

    private int recursiveKnapsack(int w, int[] wt, int[] val, int n) {
        // Base Case.
        if (n == 0 || w == 0)
            return 0;
        // Choise, either include it or not.
        if (wt[n - 1] <= w) {
            return Math.max(val[n - 1] + recursiveKnapsack(w - wt[n - 1], wt, val, n - 1),
                    recursiveKnapsack(w, wt, val, n - 1));
        } else
            return recursiveKnapsack(w, wt, val, n - 1);
    }
    

    private int memoziseKnapsack(int w, int[][] dp, int[] wt, int[] val, int n) {
        // Base Case.
        if (n == 0 || w == 0)
            return 0;
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        // Choise, either include it or not.
        if (wt[n - 1] <= w) {
            return dp[n][w] = Math.max(val[n - 1] + recursiveKnapsack(w - wt[n - 1], wt, val, n - 1),
                    recursiveKnapsack(w, wt, val, n - 1));
        } else
            return dp[n][w] = recursiveKnapsack(w, wt, val, n - 1);
    }

    private int dpKnapsack(int w, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][w + 1];
        // for (int[] k : dp) {
        //     Arrays.fill(k, 0);
        // }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                // if (i == 0 || j == 0)
                // dp[i][j] = 0; else
                if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        // Check out the dp Array for better understanding.
        // System.out.println(Arrays.deepToString(dp));
        return dp[n][w];
    }

    public static void main(String[] args) {
        Knapsack01 ob = new Knapsack01();
        int[] wt = { 1, 2, 3 };
        int[] val = { 6, 10, 12 };
        int w = 5;
        System.out.println(ob.recursiveKnapsack(w, wt, val, wt.length));
        int[][] dp = new int[wt.length + 1][w + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println(ob.memoziseKnapsack(w, dp, wt, val, wt.length));
        // System.out.println(Arrays.deepToString(dp));
        System.out.println(ob.dpKnapsack(w, wt, val, wt.length));
        System.gc();
    }
}
