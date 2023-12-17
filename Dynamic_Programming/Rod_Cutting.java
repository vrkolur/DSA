package Dynamic_Programming;

import java.util.Arrays;

public class Rod_Cutting {

    private int cutRod(int[] price, int idx, int n) {

        if (idx == 0) {
            return price[0] * n;
        }

        int notCut = cutRod(price, idx - 1, n);
        int cut = Integer.MIN_VALUE;
        int rodLength = idx + 1;
        if (rodLength <= n)
            cut = cutRod(price, idx, n - rodLength);

        return Math.max(notCut, cut);
    }

    // We will optimise it with space for time=n^2 not dp

    private int cutRod(int[] price, int idx, int[][] dp, int n) {

        if (idx == 0)
            return n * price[0];

        if (dp[idx][n] != -1)
            return dp[idx][n];

        int notCut = cutRod(price, idx - 1, n);
        int cut = Integer.MIN_VALUE;
        int rodLength = idx + 1;
        if (rodLength <= n)
            cut = cutRod(price, idx, n - rodLength);

        return dp[idx][n] = Math.max(notCut, cut);
    }

    // Now the dynamic approach is the same as that of Unbounded Knapsack

    private int cutRodDP(int[] price) {
        int n = price.length;
        int[][] t = new int[n + 1][n + 1];

        // for (int i = 0; i <= n; i++) {
        // t[i][0] = 1;
        // }
        // t[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            // See here i is the same as length[i-1] instead use i only
            for (int j = 0; j <= n; j++) {
                if (i <= j)
                    t[i][j] = Math.max(price[i - 1] + t[i][j - i], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][n];
    }

    public static void main(String[] args) {
        Rod_Cutting ob = new Rod_Cutting();
        int[] price = { 5, 6, 8, 8 };
        System.out.println(ob.cutRod(price, price.length - 1, price.length));
        int[][] dp = new int[price.length][price.length + 1];
        for (int[] it : dp)
            Arrays.fill(it, -1);
        System.out.println(ob.cutRod(price, price.length - 1, dp, price.length));
        System.out.println(ob.cutRodDP(price));
    }
}
