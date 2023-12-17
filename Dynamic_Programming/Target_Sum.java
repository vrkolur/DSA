package Dynamic_Programming;

import java.util.Arrays;

public class Target_Sum {

    // count no of subsets with the following condition.
    // s1> s2 and s1-s2=difference provided

    //This is a recursive approach
    private int findCount(int idx,int target,int[] arr,int[][] t) {
        // take s2=(total-difference)/2
        if (idx == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target==arr[0])
                return 1;
            return 0;
        }
        if (t[idx][target] != -1)
            return t[idx][target];
        int notPick = findCount(idx - 1, target, arr, t);
        int pick = 0;
        if(arr[idx]<=target)
            pick = findCount(idx - 1, target - arr[idx], arr, t);
        return t[idx][target] = pick + notPick;
    }

    private int findCount(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum - target) % 2 == 1 || target > sum)
            return 0;
        sum = (sum - target) / 2;
        int n = nums.length;
        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++)
            t[i][0] = 1;

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
        Target_Sum ob = new Target_Sum();
        int[] arr = { 1, 2, 1, 3 };
        int n = arr.length;
        int target = 1;
        int[][] t = new int[n][target + 1];
        for (int[] it : t)
            Arrays.fill(it, -1);
        //over here put the value of target as (total-target)/2;
        System.out.println(ob.findCount(n-1, target, arr, t));
        System.out.println(ob.findCount(arr, target));
    }
}
