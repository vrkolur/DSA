// package Dynamic_Programming;

import java.util.Arrays;

public class Count_no_of_Subsets_with_given_Difference {

    // This is the recursive approach
    private int findTargetSumWays(int idx, int sum, int[] nums) {
        if (idx == 0) {
            // if we have a zero we can have to ways either take or don't and it dosen't
            // make a difference
            if (sum == 0 && nums[0] == 0)
                return 2;
            if (sum == 0)
                return 1;
            if (sum == nums[0])
                return 1;
            return 0;
        }
        int notPick = findTargetSumWays(idx - 1, sum, nums);
        int pick = 0;
        if (nums[idx] <= sum)
            pick = findTargetSumWays(idx - 1, sum - nums[idx], nums);
        return pick + notPick;
    }

    // Memoziation
    private int findTargetSumWays(int idx, int sum, int[] nums, int[][] t) {
        if (idx == 0) {
            if (sum == 0 && nums[0] == 0)
                return 2;
            if (sum == 0)
                return 1;
            if (sum == nums[0])
                return 1;
            return 0;
        }
        if (t[idx][sum] != -1)
            return t[idx][sum];
        int notPick = findTargetSumWays(idx - 1, sum, nums, t);
        int pick = 0;
        if (nums[idx] <= sum)
            pick = findTargetSumWays(idx - 1, sum - nums[idx], nums, t);
        return t[idx][sum] = pick + notPick;
    }

    // Tabulation
    private int findTargetSumWays(int[] nums, int sum) {
        int n = nums.length;
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            t[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                } else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }

    // Alter if we a leading zero's
    private int findTargetSumWays1(int[] nums, int diff) {
        int total = 0;
        for (int num : nums)
            total += num;
        if ((total - diff) % 2 != 0 || diff > total)
            return 0;
        int sum = (total - diff) / 2;
        int n = nums.length;
        int[][] t = new int[n + 1][sum + 1];
        t[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                } else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        Count_no_of_Subsets_with_given_Difference ob = new Count_no_of_Subsets_with_given_Difference();
        int[] nums = { 1, 2, 3, 1 };
        int n = nums.length;
        int diff = 1;
        int total = 0;
        for (int num : nums)
            total += num;
        int sum = (total - diff) / 2;
        int[][] t = new int[n][sum + 1];
        for (int[] it : t)
            Arrays.fill(it, -1);
        System.out.println(ob.findTargetSumWays(n - 1, sum, nums));
        System.out.println(ob.findTargetSumWays(n - 1, sum, nums, t));
        System.out.println(ob.findTargetSumWays(nums, sum));
        System.out.println(ob.findTargetSumWays1(nums, diff));
    }
}
