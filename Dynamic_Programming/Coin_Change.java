package Dynamic_Programming;

import java.util.Arrays;

public class Coin_Change {

    // Return min coins that add up the given sum.

    // Recursive Approach.
    private int coinChange(int idx, int sum, int[] coins) {

        if (idx == 0) {
            if (sum == 0)
                return 0;
            if (sum % coins[0] == 0 && sum >= coins[0])
                return sum / coins[0];
            return Integer.MAX_VALUE - 123;
        }

        int notTake = coinChange(idx - 1, sum, coins);

        int take = Integer.MAX_VALUE - 123;
        if (coins[idx] <= sum)
            take = 1 + coinChange(idx, sum - coins[idx], coins);
        return Math.min(notTake, take);
    }

    // Memozation
    private int coinChange(int idx, int sum, int[] coins, int[][] t) {
        if (idx == 0) {
            if (sum == 0)
                return 0;
            if (sum % coins[0] == 0 && sum >= coins[0]) {
                return sum / coins[0];
            }
        }
        if (idx < 0)
            return Integer.MAX_VALUE - 987;
        if (t[idx][sum] != -1)
            return t[idx][sum];

        int notTake = coinChange(idx - 1, sum, coins, t);

        int take = Integer.MAX_VALUE - 9876;
        if (coins[idx] <= sum)
            take = 1 + coinChange(idx, sum - coins[idx], coins, t);
        return t[idx][sum] = Math.min(notTake, take);
    }

    // Tabulation Approach\
    private int coinChange(int[] coins, int sum) {
        int n = coins.length;
        int[][] t = new int[n ][sum + 1];

        for (int i = 0; i <= sum; i++) {
            if (i % coins[0] == 0)
                t[0][i] = i / coins[0];
            else    
                t[0][i] = Integer.MAX_VALUE - 9876;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                int notTake = t[i - 1][j];
                int take = Integer.MAX_VALUE - 9876;
                if(coins[i]<=j)
                    take = 1 + t[i][j - coins[i]];
                t[i][j] = Math.min(take, notTake);
            }
        }
        return t[n-1][sum];
    }

    public static void main(String[] args) {
        Coin_Change ob = new Coin_Change();
        // int[] coins = { 6, 5, 3, 2 };
        int[] coins = { 1, 2, 5 };
        int sum = 11;
        int n = coins.length;
        System.out.println(ob.coinChange(n - 1, sum, coins));
        int[][] t = new int[n][sum + 1];
        for (int[] it : t)
            Arrays.fill(it, -1);
        System.out.println(ob.coinChange(n - 1, sum, coins, t));
        System.out.println(ob.coinChange(coins, sum));
    }
}
