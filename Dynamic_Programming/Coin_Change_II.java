package Dynamic_Programming;

import java.util.Arrays;

public class Coin_Change_II {

    private int coinChange(int idx, int sum, int[] coins) {
        if (idx == 0) {
            if (sum == 0)
                return 1;
            if (sum % coins[0] == 0)
                return 1;
            return 0;
        }

        int notTake = coinChange(idx - 1, sum, coins);
        int take = 0;
        if (coins[idx] <= sum)
            take = coinChange(idx, sum - coins[idx], coins);
        return notTake + take;
    }

    // Memoziation

    private int coinChange(int idx, int sum, int[] coins, int[][] t) {
        if (idx == 0) {
            if (sum == 0)
                return 1;
            if (sum % coins[0] == 0)
                return 1;
            return 0;
        }
        if (t[idx][sum] != -1)
            return t[idx][sum];
        int notTake = coinChange(idx - 1, sum, coins, t);
        int take = 0;
        if (coins[idx] <= sum)
            take = coinChange(idx, sum - coins[idx], coins, t);
        return t[idx][sum] = notTake + take;
    }

    // Tabulation
    // This will be the same as subset sum equqals x

    private int coinChange(int sum, int[] coins) {
        int n = coins.length;
        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++)
            t[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j)
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        Coin_Change_II ob = new Coin_Change_II();
        int[] coins = { 1, 2, 5 };
        int n = coins.length;
        int sum = 5;
        System.out.println(ob.coinChange(n - 1, sum, coins));
        int[][] t = new int[n][sum + 1];
        for (int[] it : t)
            Arrays.fill(it, -1);
        System.out.println(ob.coinChange(n - 1, sum, coins, t));
        System.out.println(ob.coinChange(sum, coins));
    }
}
