package Dynamic_Programming;

import java.util.Arrays;

public class Frog_JumpCN {
    // This is the solution for Coding Ninjas

    // This is recursive solution for the problem
    private int findmin(int idx, int[] heights) {
        if (idx == 0)
            return 0;
        int oneStep = findmin(idx - 1, heights) + Math.abs(heights[idx] - heights[idx - 1]);
        int twoStep = 0;
        // Defining it before, id declared inside if then confined to only this if
        // statement
        if (idx > 1)
            twoStep = findmin(idx - 2, heights) + Math.abs(heights[idx] - heights[idx - 2]);
        return Math.min(oneStep, twoStep);
    }

    // This is the memoziation solution for the problem.
    // To get type of solution always check the changing variables and draw the
    // recursion tree, you will get it.
    private int findmin(int idx, int[] heights, int[] t) {
        if (idx == 0)
            return 0;
        if (t[idx] != -1)
            return t[idx];
        // Making just one jump
        int oneStep = findmin(idx - 1, heights, t) + Math.abs(heights[idx] - heights[idx - 1]);
        int twoSteps = 0;
        if (idx > 1)
            // Making two jumps.
            twoSteps = findmin(idx - 2, heights, t) + Math.abs(heights[idx] - heights[idx - 2]);
        return t[idx] = Math.min(oneStep, twoSteps);
    }

    // Now the dynamic approach
    private int findmin(int[] heights) {
        int n = heights.length;
        int[] t = new int[n];
        t[0] = 0;
        for (int i = 1; i < n; i++) {
            int fs = t[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int ss = 0;
            if (i > 1)
                ss = t[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            t[i] = Math.min(fs, ss);
        }
        return t[n - 1];
    }

    // Now Dynamic with space optimasation
    private int spaceFindMin(int[] heights) {
        int n = heights.length;
        int prev1 = 0;
        int prev2 = 0;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int fs = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            res = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = res;
        }
        return prev1;
    }

    // Now instead of 2 steps we have k steps max.
    // This is the recursive Approach
    private int kStepsJump(int idx, int k, int[] heights) {
        if (idx == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        int jump = 0;
        for (int j = 1; j <= k; j++) {
            // for k steps.
            if (idx - j >= 0) {
                jump = kStepsJump(idx - j, k, heights) + Math.abs(heights[idx] - heights[idx - j]);
                // System.out.println(jump);
                res = Math.min(res, jump);
            }
        }
        return res;
    }

    // Dynamic approach with tabulation for the kStep Approach

    private int kStepsJump(int[] heights, int k) {
        int n = heights.length;
        int jump = 0;
        int[] t = new int[n];
        t[0] = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            // calculating res for jumps with height till i;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    jump = t[i - j] + Math.abs(heights[i] - heights[i - j]);
                }
                minSteps = Math.min(minSteps, jump);
            }
            t[i] = minSteps;
        }
        return t[n -1];
    }

    public static void main(String[] args) {
        // Given heights[], frog can jump 1 step or 2 steps at a time
        // find min to reach end idx n-1;
        Frog_JumpCN ob = new Frog_JumpCN();
        int[] heights = { 30, 10, 60, 10, 60, 50 };
        int[] t = new int[heights.length];
        Arrays.fill(t, -1);
        System.out.println(ob.findmin(heights.length - 1, heights));
        System.out.println(ob.findmin(heights.length - 1, heights, t));
        System.out.println(ob.findmin(heights));
        System.out.println(ob.spaceFindMin(heights));
        System.out.println(ob.kStepsJump(heights.length - 1, 2, heights));
        System.out.println(ob.kStepsJump(heights, 2));
    }
}
