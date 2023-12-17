package Dynamic_Programming;

import java.util.Arrays;

public class House_Robber {

    private int rob(int idx, int[] nums) {
        // Suppose the idx was 2 and idx-2=0 or idx=1 then also applicable
        if (idx == 0)
            return nums[0];
        // Suppose the idx=1 and we do idx-2 return 0;
        if (idx < 0)
            return 0;
        int pick = nums[idx] + rob(idx - 2, nums);
        int notPick = rob(idx - 1, nums);

        return Math.max(pick, notPick);
    }


    // With memoziation use a 1D array

    private int rob(int idx, int[] nums, int[] t) {
        if (idx == 0)
            return nums[0];
        if (idx < 0)
            return 0;
        if (t[idx] != -1)
            return t[idx];
        int pick = nums[idx] + rob(idx - 2, nums, t);
        int notPick = rob(idx - 1, nums, t);

        return t[idx] = Math.max(pick, notPick);
    }

    // Now the Dynamic Approach (Tabulation)

    public int rob(int[] nums) {
        int n = nums.length;
        int[] t = new int[n];
        t[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1)
                pick += t[i - 2];
            int notPick = t[i - 1];
            t[i] = Math.max(pick, notPick);
        }
        return t[n - 1];
    }

    // Now Tabulation with Space optimisation.
    // I just Require the last two numbers not fully.
    // . . . . . prev2 prev1 idx;
    // Fuck this method use the above method.
    private int robt(int[] nums) {
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1)
                pick += prev2;
            int notPick = prev1;
            res = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = res;//the current result just taken.
        }
        return res;
    }

    public static void main(String[] args) {
        House_Robber ob = new House_Robber();
        int[] houses = { 2, 7, 9, 3, 1 };
        System.out.println(ob.rob(houses.length - 1, houses));
        int[] t = new int[houses.length];
        Arrays.fill(t, -1);
        System.out.println(ob.rob(houses.length - 1, houses, t));
        System.out.println(ob.rob(houses));
        System.out.println(ob.robt(houses));
    }
}
