package Dynamic_Programming;

import java.util.Arrays;

public class Count_of_Subset_with_sum_x {

    // This is the recursuive approach.

    private int countSubsets(int idx, int sum, int[] nums) {
        if (sum == 0)
            return 1;
        if (idx == 0) {
            // This last remaning number
            return sum == nums[idx] ? 1 : 0;
        }
        int notPick = countSubsets(idx - 1, sum, nums);
        int pick = 0;
        if (nums[idx] <= sum)
            pick = countSubsets(idx - 1, sum - nums[idx], nums);
        // return the sum of all 1's
        return (pick + notPick);
    }

    private int countSubsets(int idx, int sum, int[] nums, int[][] t) {
        if (sum == 0)
            return 1;
        if (idx == 0) {
            // This last remaning number
            return sum == nums[idx] ? 1 : 0;
        }
        if (t[idx][sum] != -1)
            return t[idx][sum];
        int notPick = countSubsets(idx - 1, sum, nums);
        int pick = 0;
        if (nums[idx] <= sum)
            pick = countSubsets(idx - 1, sum - nums[idx], nums);
        // return the sum of all 1's
        return t[idx][sum] = (pick + notPick);
    }

    private int countSubsets(int[] arr, int sum) {
        int n = arr.length;
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            t[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }

    // This method is with zeros in the array
    private int countSubsets1(int idx, int sum, int[] arr, int[][] t) {
        if (idx == 0) {
            // Dosent matter to the sum if we take the zero or no hence 2+
            if (sum == 0 && arr[0] == 0)
                return 2;
            if (sum == 0 || sum == arr[0])
                return 1;
            return 0;
        }
        if (t[idx][sum] != -1)
            return t[idx][sum];
        int pick = 0;
        if (arr[idx] <= sum)
            pick = countSubsets1(idx - 1, sum - arr[idx], arr, t);
        int notPick = countSubsets1(idx - 1, sum, arr, t);
        return t[idx][sum] = pick + notPick;
    }

    public static void main(String[] args) {
        Count_of_Subset_with_sum_x ob = new Count_of_Subset_with_sum_x();
        int[] arr = { 0, 0, 1 };
        int sum = 1;
        int n = arr.length;
        System.out.println(ob.countSubsets(n - 1, sum, arr));
        int[][] t = new int[n][sum + 1];
        for (int[] it : t) {
            Arrays.fill(it, -1);
        }
        // System.out.println(ob.countSubsets(n - 1, sum, arr, t));
        System.out.println(ob.countSubsets(arr, sum));
        // For the onw with zero's persent in the array
        System.out.println(ob.countSubsets1(n -1, sum, arr, t));
    }
}
